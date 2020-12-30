package sample;

public class Test {
    public static void main(String[] args) {
        int[][] n =
                {
                        {1,2,3,4,5},
                        {3,1,2,8,9},
                        {9,2,10,8,2},
                        {7,2,1,1,0}
                };
        Matrix matrix = new Matrix(4,5,n);
        //matrix.find();
        System.out.println("Đường ngắn nhất là:"+matrix.shortest());
    }
}
