import Model.Circle;
import Model.Line;
import Model.Rectangle;
import Model.Shape;
import Model.WhiteboardModel;
import Model.ShapeType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.*;

/**
 * Test class to test the white board model.
 */
public class WhiteboardModelTest {
  private WhiteboardModel model;
  private Shape line;
  private Shape rectangle;
  private Shape circle;

  /**
   * Initialize shapes and model before each test.
   */
  @Before
  public void setUp() {
    model = new WhiteboardModel();
    line = new Line(Color.BLACK, new Point(0, 0), new Point(10, 10));
    rectangle = new Rectangle(Color.RED, new Point(0, 0), 10, 20);
    circle = new Circle(Color.BLUE, new Point(5, 5), 15);
  }

  /**
   * Test adding shape.
   */
  @Test
  public void testAddShape() {
    model.addShape(line);
    assertEquals("Model should have 1 shape after adding a line", 1, model.getShapes().size());
    assertTrue("Model should contain the added line", model.getShapes().contains(line));
  }

  /**
   * Test clearing all shapes.
   */
  @Test
  public void testClearShapes() {
    model.addShape(line);
    model.addShape(rectangle);
    model.clear();
    assertTrue("Model should have no shapes after clear", model.getShapes().isEmpty());
  }

  /**
   * Test setting current shape type.
   */
  @Test
  public void testSetCurrentShapeType() {
    model.setCurrentShape(ShapeType.Rectangle);
    assertEquals("Current shape type should be RECTANGLE", ShapeType.Rectangle, model.getCurrentShapeType());
  }

  /**
   * Test setting current shape type to null.
   */
  @Test
  public void testSetShapeToNull() {
    model.setCurrentShape(ShapeType.Line);
    model.setShapeToNull();
    assertNull("Current shape type should be null", model.getCurrentShapeType());
  }

}
