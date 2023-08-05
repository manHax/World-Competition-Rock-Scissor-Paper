package JFo_Keyboard_input;

import java.util.Scanner;

public class Input04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(Input04.class.getResourceAsStream("input04.txt"));
        
        //Edit these lines to advance the scanner
        System.out.println(sc.nextLine());
        System.out.println(sc.nextLine());
        System.out.println(sc.nextLine());

        
        
        //Does this line contain "BlueBumper"?
//        System.out.println(sc.findInLine("BlueBumper"));
        //Store the next two numbers as xPosition and yPosition
        //Print these positions

//        System.out.println(sc.findWithinHorizon("444",2));

        String thisLine = sc.nextLine();
        Scanner scanner = new Scanner(thisLine);

        // Melakukan iterasi melalui string dan mencari integer
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());


        System.out.println("X: "+scanner.next()+", Y: "+scanner.next());
        scanner.close();
//        System.out.println(thisLine);
//        Scanner scLine = new Scanner(thisLine);
//        System.out.println(scLine);


        sc.close();
    }    
}
