package sample.Server;


import java.io.IOException;

public interface Server {
     void send(String data) throws IOException;
      String receiveString() throws IOException;
}


