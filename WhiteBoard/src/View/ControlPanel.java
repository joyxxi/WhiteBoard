package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A panel class with buttons to select drawing tools like line, rectangle, circle, and clear.
 * It sends user actions to the controller.
 */
public class ControlPanel extends JPanel {
  JButton lineButton;
  JButton rectangleButton;
  JButton circleButton;
  JButton clearButton;

  /**
   * Constructor to build the tool box panel view.
   */
  public ControlPanel(ActionListener actionListener) {
    // Create buttons
    this.setLayout(new FlowLayout());
    lineButton = new JButton("Line");
    lineButton.addActionListener(actionListener);
    rectangleButton = new JButton("Rectangle");
    rectangleButton.addActionListener(actionListener);
    circleButton = new JButton("Circle");
    circleButton.addActionListener(actionListener);
    clearButton = new JButton("Clear");
    clearButton.addActionListener(actionListener);

    // Add buttons to the panel
    this.add(lineButton);
    this.add(rectangleButton);
    this.add(circleButton);
    this.add(clearButton);
  }
}
