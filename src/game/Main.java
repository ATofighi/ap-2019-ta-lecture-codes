package game;

import game.swing.MainFrame;
import game.swing.MainPanel;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        MainPanel mainPanel = new MainPanel();
        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);

        new PaintLoop(mainPanel).start();
    }
}
