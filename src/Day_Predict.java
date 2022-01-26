
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {



    public static String findDay(int month, int day, int year) {

        if(month == 1) {
            month=11;
            year-=1;
        }
        else if(month == 2) {
            month=12;
            year-=1;

        }
        else month-=2;
        int y1 = year%100;
        int y2 = year/100;

        int F;
        int d;
        F = day+((13*month-1)/5)+y1+(y1/4)+(y2/4)-2*y2;
        //System.out.println(""+F+","+(F%7));
        if(F<0){
            F = F%-7;
            d = F+7;


        }
        else{
            d = F%7;
        }
        //System.out.println(""+d);
        if (d==0) return "SUNDAY";
        else if (d==1) return "MONDAY";
        else if (d==2) return "TUESDAY";
        else if (d==3) return "WEDNESDAY";
        else if (d==4) return "THURSDAY";
        else if (d==5) return "FRIDAY";
        else return "SATURDAY";

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);
        System.out.println(""+res);

        //bufferedWriter.write(res);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}


