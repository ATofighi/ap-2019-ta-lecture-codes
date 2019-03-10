package game;

import game.swing.MainPanel;

public class PaintLoop extends Thread {
    private MainPanel mainPanel;

    public PaintLoop(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public void run() {
        while (true) {
            mainPanel.moveGame();
            mainPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
