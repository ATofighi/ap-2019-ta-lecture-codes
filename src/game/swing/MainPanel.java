package game.swing;

import game.FileClassLoader;
import game.engine.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MainPanel extends JPanel {

    private Game game;

    public MainPanel() {
        setBounds(0, 0, 800, 600);
        try {
            BufferedImage bufferedImage;
            bufferedImage = ImageIO.read(new File("resources/rocket.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        game = new Game(800, 600);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_O && e.isControlDown()) {
                    JFileChooser jFileChooser = new JFileChooser();
                    if (jFileChooser.showOpenDialog(MainPanel.this) == JFileChooser.APPROVE_OPTION) {
                        File file = jFileChooser.getSelectedFile();
                        FileClassLoader fcl = new FileClassLoader(getClass().getClassLoader());
                        String className = file.getName();
                        className = className.substring(0, className.length() - ".class".length());
                        game.addChicken(fcl.loadClass(className, file));
                    }
                }
            }
        });


        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                game.getRocket().setX(e.getX());
                game.getRocket().setY(e.getY());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                game.getRocket().setX(e.getX());
                game.getRocket().setY(e.getY());
            }
        });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.shelik();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        game.paint((Graphics2D) g);
    }

    public void moveGame() {
        game.move();
    }
}
