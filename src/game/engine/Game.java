package game.engine;

import java.awt.*;
import java.util.ArrayList;

public class Game implements Animatable {

    private int width;
    private int height;

    private Rocket rocket;
    private final ArrayList<Tir> tirs = new ArrayList<>();

    public Game(int width, int height) {
        this.width = width;
        this.height = height;

        rocket = new Rocket(width / 2 - 50, height - 200);
    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(new Color(24, 37, 100));
        g2.fillRect(0, 0, width, height);


        for (Tir tir : tirs) {
            tir.paint(g2);
        }

        rocket.paint(g2);
    }

    @Override
    public void move() {
        rocket.move();
        synchronized (tirs) {
            for (Tir tir : tirs) {
                tir.move();
            }
        }
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void shelik() {
        synchronized (tirs) {
            int r = 50;
            for (int i = 0; i < 5; i++) {
                double degree = (70 + i * 10) / 180.0 * Math.PI;
                tirs.add(new Tir(rocket.getX() + r * Math.cos(degree),
                        rocket.getY() + -r * Math.sin(degree),
                        10 * Math.cos(degree),
                        -10 * Math.sin(degree)));
            }
        }
    }
}
