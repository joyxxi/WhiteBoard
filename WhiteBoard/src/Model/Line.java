package Model;

import java.awt.*;

/**
 * The class represents a line.
 */
public class Line extends Shape {
    private Point end;

  /**
   * Constructor to initialize the property of the line.
   *
   * @param color color
   * @param start start point
   * @param end end point
   */
  public Line(Color color, Point start, Point end) {
    super(color, start);
    this.end = end;
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(color);
    g.drawLine(position.x, position.y, end.x, end.y);
  }
}