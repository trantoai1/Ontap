package sample;

import sample.server.Server;
import sample.server.ServerUDP;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new ServerUDP();
        while (true) {

            System.out.println(server.receiveString());
            server.send("ok");
        }

    }
}
