package xo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Game game = new Game();
        new ClientHandler("X", game, serverSocket.accept());
        new ClientHandler("O", game, serverSocket.accept());


    }
}
