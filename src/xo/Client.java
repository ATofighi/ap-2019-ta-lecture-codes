package xo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        Scanner scanner = new Scanner(socket.getInputStream());
        PrintStream printer = new PrintStream(socket.getOutputStream());

        MainFrame mainFrame = new MainFrame();
        MainPanel mainPanel = new MainPanel(scanner, printer);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        while (true) {
            printer.println("ask");
            mainPanel.load();
        }

    }
}
