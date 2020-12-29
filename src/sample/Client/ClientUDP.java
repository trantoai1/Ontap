package sample.Client;


import java.io.IOException;
import java.net.*;

public class ClientUDP implements Client {
    public final String IP ="127.0.0.1";
    public final int PORT = 16155;
    public DatagramSocket datagramSocket;
    public DatagramPacket outPacket;
    public DatagramPacket inPacket;
    public final InetAddress SKIP ;
    public final byte[] BUFFER= new byte[20000];
    public ClientUDP() throws SocketException, UnknownHostException {
        System.out.println("Client tạo thành công");
        this.datagramSocket = new DatagramSocket();
        this.SKIP = InetAddress.getByName(IP);
    }
    public void send(byte []b) throws IOException
    {
        System.out.println("Đang gửi dữ liệu....");
        this.outPacket = new DatagramPacket(b, b.length,SKIP,PORT);
        this.datagramSocket.send(outPacket);
        System.out.println("Gửi dữ liệu thành công!");
    }
    public void send(String data) throws IOException
    {
        byte []b = data.getBytes();
        System.out.println("Đang gửi dữ liệu:["+data+"]");
        this.outPacket = new DatagramPacket(b, b.length,SKIP,PORT);
        this.datagramSocket.send(outPacket);
        System.out.println("Gửi dữ liệu thành công!");
    }
    public byte []receive() throws IOException
    {
        System.out.println("Đang nhận  dữ liệu....");
        this.inPacket = new DatagramPacket(BUFFER, BUFFER.length);
        this.datagramSocket.receive(inPacket);
        System.out.println("nhận  dữ liệu thành công");
        return inPacket.getData();
    }
    public String receiveString() throws IOException
    {
        System.out.println("Đang nhận  dữ liệu....");
        this.inPacket = new DatagramPacket(BUFFER, BUFFER.length);
        this.datagramSocket.receive(inPacket);

        byte []b = inPacket.getData();
        String result = new String(b,0,b.length).trim();
        System.out.println("nhận  dữ liệu thành công:["+result+"]");
        return result;
    }
}