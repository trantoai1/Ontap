package sample.server;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUDP implements Server {
    public DatagramSocket datagramSocket;
    public DatagramPacket outPacket;
    public DatagramPacket inPacket;
    public final int PORT = 16155;
    public final byte[] BUFFER= new byte[20000];
    public ServerUDP() throws IOException {

        this.datagramSocket = new DatagramSocket(PORT);
        System.out.println("Tạo server");
    }
    public void send(byte[] data) throws IOException
    {

        this.outPacket = new DatagramPacket(data, data.length, this.inPacket.getAddress(), this.inPacket.getPort());
        this.datagramSocket.send(outPacket);
    }
    public void send(String data) throws IOException
    {
        byte []b = data.getBytes();
        this.outPacket = new DatagramPacket(b, b.length, this.inPacket.getAddress(), this.inPacket.getPort());
        this.datagramSocket.send(outPacket);
    }
    public byte[] receive() throws IOException
    {
        System.out.println("Đang nhận dữ liệu...");
        this.inPacket = new DatagramPacket(BUFFER, BUFFER.length);
        this.datagramSocket.receive(inPacket);
        System.out.println("Nhận dữ liệu thành công");
        return inPacket.getData();
    }
    public String receiveString() throws IOException
    {
        System.out.println("Đang nhận  dữ liệu....");
        this.inPacket = new DatagramPacket(BUFFER, BUFFER.length);
        this.datagramSocket.receive(inPacket);
        byte []b = inPacket.getData();
        String result = new String(b,inPacket.getOffset(),inPacket.getLength()).trim();
        System.out.println("nhận  dữ liệu thành công:["+result+"]");
        return result;
    }
}