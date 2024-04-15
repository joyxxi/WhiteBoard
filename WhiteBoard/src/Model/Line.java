package Model;

import java.awt.*;

public class Line extends Shape {
    private Point end;

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