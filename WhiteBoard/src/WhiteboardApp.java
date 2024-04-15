import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WhiteboardApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WhiteboardModel model = new WhiteboardModel();
            WhiteboardView whiteboardView = new WhiteboardView(model);
            ToolboxView toolboxView = new ToolboxView();
            DrawingController controller = new DrawingController(model, whiteboardView, toolboxView);

            JFrame frame = new MainFrame("Whiteboard", whiteboardView, toolboxView);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
