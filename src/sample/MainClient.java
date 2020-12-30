package sample;

import sample.client.Client;
import sample.client.ClientUDP;

import java.io.IOException;
import java.util.*;

public class MainClient {



    public static void main(String[] args) throws IOException {
        //System.out.println("Bài 10:");
        //launch(args);
       // System.out.println(Controller.lietKeSNT(13));
        //System.out.println("Bài 11:");
       // System.out.println(Controller.fibo_lt(12));
        //int[] n ={9,2,67,3,4,6};
       // Optional max =Arrays.stream(n).max((o1, o2) -> o1>o2?1:-1);
        //System.out.println(max);
        //int [][]matrix ={{1,2,3,6},{2,84,3,2},{7,8,192,5}};
        //System.out.println(Controller.maxMatrix(matrix,3,3));
        Integer []n = {1,2,3,4};
        List<Integer> list = new ArrayList<>();
//
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Client client = new ClientUDP();
        while (true)
        {
            Scanner sc = new Scanner(System.in);
            String data = sc.nextLine();
            client.send(data);
            System.out.println(client.receiveString());
        }

        //System.out.println(list.size());

    }
}
