package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while(true) {
            new Thread(new ClientHandler(socket.accept())).start();
            System.out.println("Connected");
        }

    }
}
