package View;

import Controller.DrawingController;
import Model.Shape;
import Model.WhiteboardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The class is responsible for rendering the shapes on the screen.
 * It will register mouse and keyboard events and forward them to the controller.
 */
public class WhiteBoardView extends JPanel {
  private WhiteboardModel model;
  private DrawingController controller;

  /**
   * Constructor to initialize the view.
   */
  public WhiteBoardView(WhiteboardModel model) {
    this.model = model;
    this.setBackground(Color.WHITE);
//    this.addMouseListener(new MouseAdapter() {
//      @Override
//      public void mouseClicked(MouseEvent e) {
//        Point start = e.getPoint();
//        controller.drawFixedSize(start);
//        repaint();
//      }
//    });
  }

  public void addDrawingMouseListener(MouseListener mouseListener) {
    addMouseListener(mouseListener);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape shape : model.getShapes()) {
      shape.draw(g);
    }
  }
}
