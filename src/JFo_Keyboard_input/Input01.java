package JFo_Keyboard_input;

import javax.swing.*;

public class Input01 {
    public static void main(String[] args) {
        //Create a JOptionPane.
        //Store the input as a String and print it.
        String input = JOptionPane.showInputDialog("Masukkan");
        System.out.println(input);



        //Parse the input as an int.
        //Print its value +1
        try {
            System.out.println(Integer.parseInt(input));
        }catch (Exception e) {
            System.out.println(input.length());
        }

        

        //Try creating a dialog, parsing it, and initializing an int in a single line.
        //You should have only one semicolon (;) in this line.
    int tryToParse = Integer.parseInt((String) JOptionPane.showInputDialog("Masukkan"));
        System.out.println(tryToParse);

        
    }}

