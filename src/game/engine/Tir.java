package game.engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tir implements Animatable {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private BufferedImage bufferedImage;

    public Tir(double x, double y, double vx, double vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;

        try {

            // copied from http://www.java2s.com/Code/Java/Advanced-Graphics/RotatingaBufferedImage.htm
            bufferedImage = ImageIO.read(new File("resources/tir.png"));

            AffineTransform tx = new AffineTransform();
            tx.rotate(Math.atan2(vy, vx), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);

            AffineTransformOp op = new AffineTransformOp(tx,
                    AffineTransformOp.TYPE_BILINEAR);
            bufferedImage = op.filter(bufferedImage, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move() {
        x += vx;
        y += vy;
    }

    public void paint(Graphics2D g2) {
//        g2.setColor(new Color(113, 4, 5));
//        g2.setStroke(new BasicStroke(3));
//
//        double l = 25.0 / Math.sqrt(vx * vx + vy * vy);
//
//        g2.drawLine((int) (x - l * vx), (int) (y - l * vy), (int)x, (int)y);
        g2.drawImage(bufferedImage, (int)x, (int)y, null);
    }
}
