package View;

import Controller.DrawingController;
import Model.Shape;
import Model.WhiteboardModel;
import java.awt.*;
import javax.swing.*;

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
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape shape : model.getShapes()) {
      shape.draw(g);
    }
  }
}
