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

public class DrawingControllerTest {
    private WhiteboardModel model;
    private WhiteBoardView view;
    private DrawingController controller;

    @Before
    public void setUp() {
        model = new WhiteboardModel();
        view = new WhiteBoardView(model);
        controller = new DrawingController(model, view);
    }

    @Test
    public void testDrawLine() {
        model.setCurrentShape(ShapeType.Line);

        Point startPoint = new Point(100, 100);
        controller.drawFixedSize(startPoint);
        List<Shape> shapes = model.getShapes();

        assertEquals(1, shapes.size());
        assertTrue(shapes.get(0) instanceof Line);
    }

    @Test
    public void testDrawRectangle() {
        model.setCurrentShape(ShapeType.Rectangle);

        Point startPoint = new Point(200, 200);
        controller.drawFixedSize(startPoint);
        List<Shape> shapes = model.getShapes();

        assertTrue("No shapes found", !shapes.isEmpty());

        assertEquals("Unexpected number of shapes", 1, shapes.size());
    }

    @Test
    public void testClearShapes() {
        model.addShape(new Line(Color.BLACK, new Point(100, 100), new Point(150, 150)));

        model.clear();
        List<Shape> shapes = model.getShapes();

        assertTrue(shapes.isEmpty());
    }
}
