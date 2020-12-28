package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {



    public static void main(String[] args) {
        //System.out.println("Bài 10:");
        //launch(args);
       // System.out.println(Controller.lietKeSNT(13));
        //System.out.println("Bài 11:");
       // System.out.println(Controller.fibo_lt(12));
        //Integer[] n ={9,2,67,3,4,6};
       // Optional max =Arrays.stream(n).max((o1, o2) -> o1>o2?1:-1);
        //System.out.println(max);
        int [][]matrix ={{1,2,3,6},{2,84,3,2},{7,8,192,5}};
        //System.out.println(Controller.maxMatrix(matrix,3,3));

       // System.out.println(Controller.timNguyenTo(matrix,3,3));
        Controller.sortColumes(matrix,3,4);
        for (int i=0;i<3;i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
