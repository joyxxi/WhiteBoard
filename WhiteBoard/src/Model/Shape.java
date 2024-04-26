package Model;

import java.awt.*;

/**
 * The abstract class represents all shapes.
 */
public abstract class Shape {
  protected Color color;
  protected Point position;

  /**
   * Constructor to initialize the color and position of the shape.
   *
   * @param color color of the shape
   * @param position position of the shape
   */
  public Shape(Color color, Point position) {
    this.color = color;
    this.position = position;
  }

  /**
   * Perform drawing.
   *
   * @param g graphics
   */
  public abstract void draw(Graphics g);
}