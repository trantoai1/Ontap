package sample;

import java.util.*;

public class Matrix {
    public int w;
    public int h;
    public int [][] matrix ;

    public Matrix()
    {
        allRoad = new ArrayList<>();
    }
    public Matrix(int n,int m,int[][] arr)
    {
        allRoad = new ArrayList<>();
        this.h = n;
        this.w = m;
        matrix =  new int[h][];
        for(int i=0;i<h;i++)
        {
            matrix[i] = new int[w];
            for(int j=0;j<w;j++)
            {
                matrix[i][j] = arr[i][j];
            }
        }
        this.find();
    }

    private List<Node> allRoad ;
    public String shortest()
    {
        if(!allRoad.isEmpty())
        {
            allRoad.sort((o1, o2) -> o1.getSum()>o2.getSum()?1:-1);
            return allRoad.get(0).duongDi();
        }
        else
        {
            return "Không có đường đi";
        }
    }
    public void find()
    {
        List<Integer> result = new ArrayList<>();
        find(0,0,result);
    }
    public void find(int x, int y, List<Integer> result)
    {   result.add(matrix[x][y]);
        if(x==this.h-1 && y== this.w-1)
        {
            Node n = new Node(result);
            allRoad.add(n);
            return;}
        List<Integer> tempList = new ArrayList<>();
        tempList.addAll(result);
        if(x<this.h-1 && y<this.w-1)
            find(x+1,y+1,result);
        result.clear();
        result.addAll(tempList);
        if(x < this.h-1) {
            find(x + 1, y, result);
            result.clear();
            result.addAll(tempList);
        }
        if (y < this.w-1)
            find(x,y+1,result);
        result.clear();
        result.addAll(tempList);

    }
}
class Node {

    private Integer sum =0;
    private List<Integer> list = new ArrayList<>();
    public Node (List<Integer> list)
    {
        this.list.addAll(list);
        for (Integer i:this.list
        ) {
            sum+=i;
        }
    }
    public int getSum()
    {
        return sum;
    }
    public String duongDi() throws StringIndexOutOfBoundsException
    {
        String result = sum+"=";
        for (Integer i:list
        ) {
            result+=i+"->";
        }
        result=result.substring(0, result.length()-2);
        return result;
    }

}