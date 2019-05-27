package game;

import java.awt.*;

public class LineChicken implements ChickenInterface{
    private int x;
    private int y = 50;
    private int speed = 8;
    final private int radius = 24;

    public LineChicken(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean makeEgg() {
        return Math.random() < 0.1;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public void move() {
        x += speed;
        if (x < 0 || x > 500) {
            speed *= -1;
        }
    }

    public boolean isInside(int x, int y) {
        return (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y) < radius * radius;
    }

    @Override
    public String toString() {
        return "game.LineChicken{" +
                "x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                ", radius=" + radius +
                '}';
    }
}
