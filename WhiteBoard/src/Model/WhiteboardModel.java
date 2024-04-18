package Model;

import Model.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * The class to represent the shapes to be drawn, their properties, and the state of the whiteboard.
 */
public class WhiteboardModel {
  private ShapeType currentShapeType;
  private List<Shape> shapes;

  /**
   * Constructor to initialize the whiteboard model.
   */
  public WhiteboardModel() {
    this.currentShapeType = ShapeType.Line;
    shapes = new ArrayList<>();
  }

  public void addShape(Shape shape) {
    shapes.add(shape);
  }

  public void removeShape(Shape shape) {
    shapes.remove(shape);
  }

  public List<Shape> getShapes() {
    return shapes;
  }

  /**
   * Set the current shape type to the given type.
   *
   * @param shape given shape type
   */
  public void setCurrentShape(ShapeType shape) {
    this.currentShapeType = shape;
  }

  /**
   * Return current shape type of the model.
   *
   * @return current shape type
   */
  public ShapeType getCurrentShapeType() {
    return this.currentShapeType;
  }

  /**
   * Clear all shapes in the model.
   */
  public void clear() {
    shapes.clear();
  }
}