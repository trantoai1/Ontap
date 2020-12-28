package sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

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
    /*Bài 2*/
    public static String tongCacChuSo(Long number)
    {
        //Long tem = new Long("999999999999");

        int sum = -1;
        try {
            sum = 0;
            while(number>0)
            {
                sum+= number%10;
                number/=10;
            }
            return "result:"+String.valueOf(sum);
        } catch (Exception e) {
            return "error:"+e.getMessage();
        }
    }
    /*Bài 3*/
    public static String thuaSoNguyenTo(int number)
    {
        String result = "";
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
        return "result:"+result;
    }
    /*Bài 4*/
    public static boolean isSNT(int number)
    {
        int count = 0;
        for (int i = 2; i < number; i++) {
            if (number%i==0) count++;
        }
        if (count == 0)
            return true;
        return false;
    }
    public static String cacSoNguyenTo(int number)
    {
        String result = "";
        for (int i = 2; i < number; i++) {
            if(isSNT(i)) result+= i+"|";
        }
        result=result.substring(0, result.length()-1);
        return "result:"+result;
    }
    /*Bài 5*/
    public static boolean isThuanNghich(int number)
    {
        String num = String.valueOf(number);
        if(num.equals(new StringBuilder(num).reverse().toString()))
            return true;
        return false;
    }
    public static String lietKeThuanNghich()
    {
        String result = "";
        for (int i = 100000; i < 1000000; i++) {
            if(isThuanNghich(i))result+= i+"|";
        }
        result=result.substring(0, result.length()-1);
        return "result:"+result;
    }
    /*Bài 6,7*/
    public static String dayXuatHien(List<Integer> ds, int solan)
    {
        String result = "";
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (Integer d : ds) {
            if(map.containsKey(d))
                map.put(d, map.get(d)+1);
            else
                map.put(d, 1);

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value == solan)
                result+= key+"|";
        }
        result=result.substring(0, result.length()-1);
        return "result:"+result;
    }
    public static String lietKeSoLan(List<Integer> ds)
    {
        String result = "";
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (Integer d : ds) {
            if(map.containsKey(d))
                map.put(d, map.get(d)+1);
            else
                map.put(d, 1);

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

                result+= key+"|";
        }
        result=result.substring(0, result.length()-1);
        return "result:"+result;
    }
}
