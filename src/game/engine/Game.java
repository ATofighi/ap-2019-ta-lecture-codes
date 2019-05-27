package game.engine;

import game.ChickenInterface;
import game.LineChicken;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Game implements Animatable {

    private int width;
    private int height;

    private Rocket rocket;
    private final ArrayList<Tir> tirs = new ArrayList<>();
    private Class chickenClass;
    private ChickenInterface chicken;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;

        rocket = new Rocket(width / 2 - 50, height - 200);
        addChicken(LineChicken.class);
    }

    public void addChicken(Class chickenClass) {
        this.chickenClass = chickenClass;
        try {
            Constructor cons = chickenClass.getConstructor(int.class, int.class);
            chicken = (ChickenInterface) cons.newInstance(50, 50);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics2D g2) {
        g2.setColor(new Color(24, 37, 100));
        g2.fillRect(0, 0, width, height);


        for (Tir tir : tirs) {
            tir.paint(g2);
        }

        if (chicken != null) {
            chicken.paint(g2);
//            try {
//                chickenClass.getMethod("paint", Graphics2D.class).invoke(chicken, g2);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
        }
        rocket.paint(g2);
    }

    @Override
    public void move() {
        rocket.move();
        if (chicken != null) {
            chicken.move();
//            try {
//                chickenClass.getMethod("move").invoke(chicken);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
        }
        for (Tir tir : tirs) {
            tir.move();
        }
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void shelik() {
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
