package xo;

import java.io.PrintStream;

public class Game {
    private String currentTurn = "X";
    private String[][] board = new String[3][3];

    public Game() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }


    private String getWinner() {
        for (int i = 0; i < 3; i++) {
            String s = board[i][0];
            boolean ok = !s.equals("");
            for (int j = 0; j < 3; j++) {
                if (!s.equals(board[i][j])) {
                    ok = false;
                }
            }
            if (ok) {
                return s;
            }
        }


        for (int i = 0; i < 3; i++) {
            String s = board[0][i];
            boolean ok = !s.equals("");
            for (int j = 0; j < 3; j++) {
                if (!s.equals(board[j][i])) {
                    ok = false;
                }
            }
            if (ok) {
                return s;
            }
        }
        {
            String s = board[0][0];
            boolean ok = !s.equals("");
            for (int j = 0; j < 3; j++) {
                if (!s.equals(board[j][j])) {
                    ok = false;
                }
            }
            if (ok) {
                return s;
            }
        }

        {
            String s = board[0][2];
            boolean ok = !s.equals("");
            for (int j = 0; j < 3; j++) {
                if (!s.equals(board[j][2 - j])) {
                    ok = false;
                }
            }
            if (ok) {
                return s;
            }
        }
        return "-";
    }

    public String getAndNextTurn() {
        String nextTurn = "X";
        if (currentTurn.equals("X")) {
            nextTurn = "O";
        }

        String temp = currentTurn;
        currentTurn = nextTurn;

        return temp;
    }


    public boolean isFinished() {
        return getWinner() != null;
    }

    public void click(String name, int i, int j) {
        if (name.equals(currentTurn) && i >= 0 && i < 3 && j >= 0 && j < 3) {
            if (board[i][j].equals("")) {
                board[i][j] = name;
                getAndNextTurn();
            }
        }
    }

    public void printTo(PrintStream printer) {
        printer.println(currentTurn);
        printer.println(getWinner());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                printer.println(board[i][j]);
            }
        }
    }
}
