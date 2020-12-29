package sample.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientTCP implements Client {
    public Socket socket;
    public DataOutputStream out;
    public DataInputStream in;
    public ClientTCP() throws IOException
    {
        socket = new Socket("localhost",17155);
        System.out.println("tạo client thành công");
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        System.out.println("bắt đầu kết nối...");
        this.send("started");
        if(this.receiveString().equals("connected"))
        {
            System.out.println("kết nối thành công");
        }
        else
            System.out.println("kết nối thất bại");
    }
    public void send(String data) throws IOException {
        this.out.writeUTF(data);
    }
    public String receiveString() throws IOException
    {
        return this.in.readUTF();
    }
}
