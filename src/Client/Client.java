package Client;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String IP = "127.0.0.1";
    private static final int Port = 8080;
    private static BufferedWriter out;
    private static BufferedReader in;
    private static Socket client;


    public void connect() throws IOException {
        client = new Socket(IP,Port);
        out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }
}
