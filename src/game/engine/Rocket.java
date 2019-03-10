package game.engine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Rocket implements Animatable {
    private int x;
    private int y;

    private BufferedImage bufferedImage;


    public Rocket(int x, int y) {
        this.x = x;
        this.y = y;

        try {
            bufferedImage = ImageIO.read(new File("resources/rocket.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paint(Graphics2D g2) {
//        g2.setColor(new Color(135, 109, 79));
//        g2.fillRect(x - 50, y - 25, 100, 50);
        g2.drawImage(bufferedImage, x - bufferedImage.getWidth()/2, y - bufferedImage.getHeight()/2, null);
    }

    @Override
    public void move() {

    }
}
