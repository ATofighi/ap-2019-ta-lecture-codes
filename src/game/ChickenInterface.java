package game;

import java.awt.*;

public interface ChickenInterface {
    boolean makeEgg();
    void paint(Graphics2D g);
    void move();
    boolean isInside(int x, int y);
}
