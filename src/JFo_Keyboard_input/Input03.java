package JFo_Keyboard_input;

import javax.swing.*;
import java.util.Scanner;

class Input03 {

    public static void main(String[] args) {
//        String input = JOptionPane.showInputDialog("Masukkan");
//        System.out.println(input);
//        try {
//            System.out.println(Integer.parseInt(input));
//        }catch (Exception e) {
//            System.out.println(input.length());
//        }
//
//        //Create a Scanner
        Scanner sc = new Scanner(System.in);

        
        //Find and print the sum of three integers entered by the user

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println((a+b+c));
        sc.close();
        
        
        
        
        //Remember to close the Scanner
        
    }
}
