package Controller;// Controller.DrawingController.java
import Model.*;
import View.ToolboxView;
import View.WhiteBoardView;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingController {
    private WhiteboardModel model;
    private WhiteBoardView whiteboardView;
    private ToolboxView toolboxView;
    private String currentTool;

    public DrawingController(WhiteboardModel model, WhiteBoardView whiteboardView, ToolboxView toolboxView) {
        this.model = model;
        this.whiteboardView = whiteboardView;
        this.toolboxView = toolboxView;
        this.currentTool = "Line"; // Default tool

        this.whiteboardView.addMouseListener(new DrawingAreaMouseListener());
        this.toolboxView.addToolboxListener();
    }

    private class DrawingAreaMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            Point start = e.getPoint();
            Shape shape;

            switch (currentTool) {
                case "Line":
                    shape = new Line(Color.BLACK, start, start);
                    break;
                case "Rectangle":
                    shape = new Rectangle(Color.BLACK, start, 0, 0);
                    break;
                case "Circle":
                    shape = new Circle(Color.BLACK, start, 10);
                    break;
                default:
                    shape = null;
            }

            if (shape != null) {
                model.addShape(shape);
            }
        }

    }

    private class ToolboxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentTool = e.getActionCommand();
        }
    }
}
