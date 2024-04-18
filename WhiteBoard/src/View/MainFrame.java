package View;

import Controller.DrawingController;
import Model.WhiteboardModel;

import javax.swing.*;
import java.awt.*;

/**
 * The main Frame class that holds the WhiteboardView and ToolboxView.
 */
public class MainFrame extends JFrame {
  public static final int WIDTH = 800;
  public static final int HEIGHT = 600;

  /**
   * Constructor to build the initial window.
   */
  public MainFrame() {
    super("Whiteboard");

    WhiteboardModel whiteboardModel = new WhiteboardModel();
    WhiteBoardView whiteBoardView = new WhiteBoardView(whiteboardModel);
    DrawingController controller = new DrawingController(whiteboardModel, whiteBoardView);
    ControlPanel controlPanel = new ControlPanel(controller);

    getContentPane().add(controlPanel, BorderLayout.NORTH);
    getContentPane().add(whiteBoardView, BorderLayout.CENTER);

    this.setDefaultCloseOperation(3);
    this.setLocationRelativeTo(null);
    this.setSize(WIDTH, HEIGHT);
    setVisible(true);
  }
}
