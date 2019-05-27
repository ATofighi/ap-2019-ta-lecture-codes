package xo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MainPanel extends JPanel {
    private String currentTurn = "X";
    private String winner = "";
    private GameButton[][] buttons = new GameButton[3][3];
    private Scanner scanner;
    private PrintStream printer;

    public MainPanel(Scanner scanner, PrintStream printer) {
        this.scanner = scanner;
        this.printer = printer;
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new GameButton(this, i, j, printer);
                add(buttons[i][j]);
            }
        }
    }



    public void load() {
        boolean oldFinish = isFinished();
        currentTurn = scanner.next();
        winner = scanner.next();
        if(winner.equals("-")) winner = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText(scanner.next());
            }
        }

        if (isFinished() && !oldFinish) {
            JOptionPane.showMessageDialog(this, getWinner() + " wins!");
        }
    }

    public boolean isFinished() {
        return !winner.equals("");
    }

    public String getWinner() {
        return winner;
    }
}
