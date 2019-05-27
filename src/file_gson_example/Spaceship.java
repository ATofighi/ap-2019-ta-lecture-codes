package file_gson_example;

import com.google.gson.Gson;

import java.io.PrintStream;
import java.util.Scanner;

public class Spaceship {
    private int x;
    private int y;
    private long lastDagh = 0;
    private int bombs = 10;

    public Spaceship(int x, int y) {
        this.x = x;
        this.y = y;
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

    public long getLastDagh() {
        return lastDagh;
    }

    public void setLastDagh(long lastDagh) {
        this.lastDagh = lastDagh;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public void save(PrintStream p) {
        Gson gson = new Gson();
        p.println(gson.toJson(this));
    }

    public static Spaceship load(Scanner s) {
        Gson gson = new Gson();
        return gson.fromJson(s.nextLine(), Spaceship.class);
    }


    @Override
    public String toString() {
        return "Spaceship{" +
                "x=" + x +
                ", y=" + y +
                ", lastDagh=" + lastDagh +
                ", bombs=" + bombs +
                '}';
    }
}
