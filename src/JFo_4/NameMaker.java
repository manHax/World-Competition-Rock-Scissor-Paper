package JFo_4;

import javax.swing.*;

public class NameMaker {
    public static String createFullName(String ...args){
        String fullName = "";
        for (String arg :args){
            fullName=fullName+" "+arg;
        }return fullName.trim();
    }
    
    public static void main(String args[])
    {
        String firstName, middleName,lastName;//, fullName;
        firstName = JOptionPane.showInputDialog("Masukkan Nama Depan");
        middleName = JOptionPane.showInputDialog("Masukkan Nama Tengah");
        lastName = JOptionPane.showInputDialog("Masukkan Nama Belakang");

        System.out.println(createFullName(firstName,middleName,lastName));

    }
    
}
