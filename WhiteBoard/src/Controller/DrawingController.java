package Controller;
import Model.*;
import View.PopUpView;
import View.WhiteBoardView;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Interacts with model and view, listen to actions from views, updates the model and refreshes views.
 */
public class DrawingController implements ActionListener {
  private WhiteboardModel model;
  private WhiteBoardView view;

  /**
   * Constructor to initialize the model and view.
   *
   * @param model model
   * @param view view
   */
  public DrawingController(WhiteboardModel model, WhiteBoardView view) {
    this.model = model;
    this.view = view;
    attachListeners();
  }

  /**
   * Add mouse listener to the view, and perform action accordingly.
   */
  private void attachListeners() {
    view.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        Point start = e.getPoint();
        if (model.getCurrentShapeType() == null) {
          PopUpView.drawNotAllow(view);
        } else {
          drawFixedSize(start);
        }
        view.repaint();
      }
    });
  }

  /**
   * Update the model based on where the user clicked.
   *
   * @param start clicked starting point
   */
  public void drawFixedSize(Point start) {
    Point end = new Point(start.x + 50, start.y);
    ShapeType currentShape = model.getCurrentShapeType();
    Shape shape;
    shape = switch (currentShape) {
      case Line -> new Line(Color.BLACK, start, end);
      case Rectangle -> new Rectangle(Color.BLACK, start, 50, 20);
      case Circle -> new Circle(Color.BLACK, start, 50);
    };
    model.addShape(shape);
  }

  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    switch (command) {
      case "Line":
        model.setCurrentShape(ShapeType.Line);
        break;
      case "Rectangle":
        model.setCurrentShape(ShapeType.Rectangle);
        break;
      case "Circle":
        model.setCurrentShape(ShapeType.Circle);
        break;
      case "Clear":
        model.setShapeToNull();
        model.clear();
        view.repaint();
        break;
      default:
        break;
    }
  }
}
