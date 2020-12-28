package sample;

import java.util.*;
import java.util.stream.IntStream;

public class Controller {
    /*Bài 1: Viết chương trình chuyển đổi một số tự nhiên ở hệ cơ số 10 thành số ở hệ cơ số b bất kì (1< b≤ 24). */
    public static String doiHeSo(int coso, int number)
    {
        String []A = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N"};
        if(coso <=1 || coso >24) return "error:Cơ số không hợp lệ";
        String result = "";
        while(number > 0)
        {
            result = A[number%coso]+ result;
            number /= coso;
        }
        return "result:"+result;
    }
    /*Bài 2:Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ.*/
    private  static  int sumChuSo(int number) throws  NumberFormatException
    {
        int sum = 0;
            while(number>0)
            {
                sum+= number%10;
                number/=10;
            }
            return sum;

    }
    public static String tongCacChuSo(int number)
    {
        try {

            return "result:"+String.valueOf(sumChuSo(number));
        } catch (Exception e) {
            return "error:"+e.getMessage();
        }
    }
    /*Bài 3:Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố */
    public static String thuaSoNguyenTo(int number)
    {
        String result = "result:";
        int i=2;
        while(i <=number)
        {
            while (number%i ==0)
            {
                result+= i +"x";
                number/=i;
            }
            i++;

        }
        result=result.substring(0, result.length()-1);
        return result;
    }
    /*Bài 4:Viết chương trình liệt kê tất cả các số nguyên tố nhỏ hơn n cho trước*/
    private static boolean isSNT(int number)
    {
        int count = 0;
        if(number <=1) return false;
        for (int i = 2; i < number; i++) {
            if (number%i==0) count++;
        }
        if (count == 0)
            return true;
        return false;
    }
    public static String cacSoNguyenTo(int number)
    {
        String result = "result:";
        for (int i = 2; i < number; i++) {
            if(isSNT(i)) result+= i+"|";
        }
        result=result.substring(0, result.length()-1);
        return result;
    }
    /*Bài 5:Một số được gọi là số thuận nghịch độc nếu ta đọc từ trái sang phải hay từ phải sang trái số đó ta vẫn nhận được một số giống nhau. Hãy liệt kê tất cả các số thuận nghịch độc có sáu chữ số */
    public static boolean isThuanNghich(int number)
    {
        String num = String.valueOf(number);
        if(num.equals(new StringBuilder(num).reverse().toString()))
            return true;
        return false;
    }
    public static String lietKeThuanNghich()
    {
        String result = "result:";
        for (int i = 100000; i < 1000000; i++) {
            if(isThuanNghich(i))result+= i+"|";
        }
        result=result.substring(0, result.length()-1);
        return result;
    }
    /*Bài 6,7,8: Hãy liệt kê các phần tử xuất hiện trong dãy*/
    private static   Map<Integer,Integer> lietKeDay(List<Integer> ds)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (Integer d : ds) {
            if(map.containsKey(d))
                map.put(d, map.get(d)+1);
            else
                map.put(d, 1);

        }
       // Collections.sort(ds,(o1, o2) -> o1.compareTo(o2)>0?-1:1);

        return  map;
    }
    public static String dayXuatHien(List<Integer> ds, int solan)
    {
        String result = "result:";

        for (Map.Entry<Integer, Integer> entry : lietKeDay(ds).entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value == solan)
                result+= key+"|";
        }
        result=result.substring(0, result.length()-1);
        return result;
    }
    public static String lietKeSoLan(List<Integer> ds)
    {
        String result = "result:";
        for (Map.Entry<Integer, Integer> entry : lietKeDay(ds).entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

                result+= key+"&"+value+"|";
        }
        result=result.substring(0, result.length()-1);
        return result;
    }
    /*Bài 10: Viết chương trình liệt kê tất cả các số nguyên tố có 5 chữ số sao cho tổng của các chữ số trong mỗi số nguyên tố đều bằng S cho trước*/
    public static String lietKeSNT(int S)
    {
        String result = "result:";
        for (int i=10000;i<=99999;i++)
        {
            if(isSNT(i)&&sumChuSo(i)==S)
            {
                result+= i+"|";
            }
        }
        result=result.substring(0, result.length()-1);
        return result;
    }
    /*Bài 11: Nhập một số tự nhiên n. Hãy liệt kê các số Fibonaci nhỏ hơn n là số nguyên tố. */
    public static String fibo_lt(int n)
    {
        String result = "result:1|";
        int fi=1,i=1;

       while(fi<n)
       {
           result+=fi+"|";
           int temp = fi;
            fi+=i;
            i= temp;

       }
        result=result.substring(0, result.length()-1);
        return result;
    }
    /*Bài 15: Viết chương trình nhập vào vào ma trận A có n dòng, m cột, các phần tử là những số nguyên lớn hơn 0 và nhỏ hơn 100 được nhập vào từ bàn phím*/
    public static int maxMatrix(int [][]matrix,int n,int m)
    {
        int []maxs = new int[n];
        for(int i=0;i<n;i++)
        {
            maxs[i] = Arrays.stream(matrix[i]).max().getAsInt();
        }
        int max = Arrays.stream(maxs).max().getAsInt();
        return max;
    }
    public  static  String timNguyenTo(int [][]matrix,int n,int m)
    {
        String result = "result:";
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                if(isSNT(matrix[i][j]))
                {
                    result+= matrix[i][j]+"|";
                }
                else
                {
                    matrix[i][j] = 0;
                    result+= matrix[i][j]+"|";
                }
            }
        }
        result=result.substring(0, result.length()-1);
        return result;
    }
    public static void sortColumes(int [][]matrix,int n,int m)
    {
        int []temp = new int[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                temp[j]=matrix[j][i];
            }
            IntStream stream = Arrays.stream(temp).sorted();
            temp = stream.toArray();
            for(int j=0;j<n;j++)
            {
                matrix[j][i] = temp[j];
            }
        }

    }
    /*Bài 16:Viết chương trình nhập vào vào mảng A có n phần tử*/
    public static void sortMatrix(int[] matrix,int n)
    {
        Integer[] what = Arrays.stream( matrix ).boxed().toArray( Integer[]::new );
        //IntStream stream=Arrays.stream(matrix).sorted();

        List<Integer> list = Arrays.asList(what);
        list.sort(((o1, o2) -> o1 > o2?-1:1));
        int k=0;
        for (Integer i: list
             ) {

            matrix[k] = i;
            k++;
        }


    }
}
