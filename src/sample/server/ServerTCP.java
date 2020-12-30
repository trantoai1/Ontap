package sample.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP implements Server {
    public ServerSocket svr;
    public Socket client;
    public DataOutputStream out;
    public DataInputStream in;
    public ServerTCP() throws IOException {
        this.svr = new ServerSocket(17155);
        System.out.println("Khởi tạo server thành công...");
        System.out.println("Chờ client...");
        this.client = svr.accept();
        out = new DataOutputStream(client.getOutputStream());
        in = new DataInputStream(client.getInputStream());
        this.receiveString().equals("started");
        System.out.println("Client đã kết nối!");
        this.send("connected");

    }
    public void send(String data) throws IOException {
        this.out.writeUTF(data);
    }
    public String receiveString() throws IOException
    {
        return this.in.readUTF();
    }
}