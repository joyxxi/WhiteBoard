package Model;

import java.awt.*;

/**
 * The class represents a rectangle.
 */
public class Rectangle extends Shape {
  private int width;
  private int height;

  /**
   * Constructor to initialize the property of rectangle.
   *
   * @param color color
   * @param position position
   * @param width width
   * @param height height
   */
  public Rectangle(Color color, Point position, int width, int height) {
    super(color, position);
    this.width = width;
    this.height = height;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(position.x, position.y, width, height);
  }
}