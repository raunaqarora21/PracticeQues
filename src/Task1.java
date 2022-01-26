import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr));
        char [] ar = new char[12];
        s.getChars(0,4,ar,0);
        System.out.println(Arrays.toString(ar));





    }
}
