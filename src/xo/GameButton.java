package xo;

import javax.swing.*;
import java.io.PrintStream;

public class GameButton extends JButton {
    private MainPanel game;

    public GameButton(MainPanel game, int i, int j, PrintStream printer) {
        this.game = game;

        addActionListener((e -> {
            if (this.getText().equals("") && !game.isFinished()) {
//                this.setText(game.getAndNextTurn());
                printer.println("click " + i + " " + j);
            }
        }));
    }

}
