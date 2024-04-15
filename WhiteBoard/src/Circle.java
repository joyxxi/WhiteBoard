import java.awt.*;

public class Circle extends Shape {
    private int diameter;

    public Circle(Color color, Point position, int diameter) {
        super(color, position);
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.x, position.y, diameter, diameter);
    }
}