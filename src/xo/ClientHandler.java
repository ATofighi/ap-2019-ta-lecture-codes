package xo;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
    private Socket socket;

    public ClientHandler(String name, Game game, Socket socket) {
        this.socket = socket;
        try {
            Scanner scanner = new Scanner(socket.getInputStream());

            PrintStream printer = new PrintStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    String action = scanner.next();
                    System.out.println(name + " " + action);
                    switch (action) {
                        case "click":
                            game.click(name, scanner.nextInt(), scanner.nextInt());
                            break;
                        case "ask":
                            game.printTo(printer);
                            break;
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
