package JFo_5;

import java.util.Scanner;

public class ColorRange {
    /*
    Violet 380-450
Blue 450-495
Green 495-570
Yellow 570-590
Orange 590-620
Red 620-750
*/

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number:");
        int colorCode = in.nextInt();
        if (colorCode>=380 && colorCode<450){
            System.out.println("The color is Violet");
        } else if (colorCode<495){
            System.out.println("The color is Blue");
        } else if (colorCode<570){
            System.out.println("The color is Green");
        } else if (colorCode<590){
            System.out.println("The color is Yellow");
        } else if (colorCode<620){
            System.out.println("The color is Orange");
        } else if (colorCode<750){
            System.out.println("The color is Red");
        }

    }
    }
