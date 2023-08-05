package JFo_4;

import java.util.Locale;
import java.util.Scanner;

public class ProcessName {
    public String foo (int q, int b, int c, int d,int e,int f){
        return null;
    }
    public static void main(String[] args) {
        System.out.println("Type your name: ");
        Scanner inputName = new Scanner(System.in);
        String strInputName = inputName.nextLine();

        System.out.println("Your name is: "+strInputName.substring(strInputName.indexOf(" "))+", "+strInputName.substring(0,1)+".");
    }
}
