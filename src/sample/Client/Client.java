package sample.Client;


import java.io.IOException;

public interface Client {
     void send(String data) throws IOException;
      String receiveString() throws IOException;
}


