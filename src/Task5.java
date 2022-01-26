import java.sql.SQLOutput;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int i;
        System.out.print("index:  ");
        for(i=0;i<s.length();i++){
            System.out.print(i);
            if(i!=s.length()-1) System.out.print("\t");
        }
        System.out.println();
        System.out.print("chars:  ");
        for(i=0;i<s.length();i++){

            System.out.print(s.charAt(i));
            if(i!=s.length()-1) System.out.print("\t");

        }

    }
}
