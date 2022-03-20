package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket client;
    private final BufferedReader reader;
    private final PrintWriter writer;


    public ClientHandler(Socket socket) throws IOException {
        this.client = socket;
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        writer = new PrintWriter(client.getOutputStream());
    }

    @Override
    public void run() {

    }

}
