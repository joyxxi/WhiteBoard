import Model.WhiteboardModel;
import Model.Shape;
import Model.ShapeType;
import Model.Line;
import Controller.DrawingController;
import View.WhiteBoardView;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Test class to test drawing controller.
 */
public class DrawingControllerTest {
  private WhiteboardModel model;
  private WhiteBoardView view;
  private DrawingController controller;

  /**
   * Initialize the model, view and controller before each test.
   */
  @Before
  public void setUp() {
    model = new WhiteboardModel();
    view = new WhiteBoardView(model);
    controller = new DrawingController(model, view);
  }

  /**
   * Test drawing line.
   */
  @Test
  public void testDrawLine() {
    model.setCurrentShape(ShapeType.Line);

    Point startPoint = new Point(100, 100);
    controller.drawFixedSize(startPoint);
    List<Shape> shapes = model.getShapes();

    assertEquals(1, shapes.size());
    assertTrue(shapes.get(0) instanceof Line);
  }

  /**
   * Test drawing rectangle.
   */
  @Test
  public void testDrawRectangle() {
    model.setCurrentShape(ShapeType.Rectangle);

    Point startPoint = new Point(200, 200);
    controller.drawFixedSize(startPoint);
    List<Shape> shapes = model.getShapes();

    assertFalse("No shapes found", shapes.isEmpty());

    assertEquals("Unexpected number of shapes", 1, shapes.size());
  }

  /**
   * Test clearing all shapes.
   */
  @Test
  public void testClearShapes() {
    model.addShape(new Line(Color.BLACK, new Point(100, 100), new Point(150, 150)));

    model.clear();
    List<Shape> shapes = model.getShapes();

    assertTrue(shapes.isEmpty());
  }
}
