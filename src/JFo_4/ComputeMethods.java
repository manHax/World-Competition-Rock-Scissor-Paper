package JFo_4;

import java.util.Random;
import java.lang.Math;

public class ComputeMethods {
    public double FahrenheitToCelsius(int f){
        //C=5/9*(F-32)
        return (double) 5/9*(f-32);
    }
//    Computes the hypotenuse length of a triangle given its side lengths
    public double hypotenuseLengthC (int a, int b){
        return Math.sqrt( Math.pow(a,2) + Math.pow(b,2) );
    }
    public int roll(){
        Random dice1 = new Random();
        Random dice2 = new Random();

        return dice1.nextInt(7)+1 + dice2.nextInt(7)+1;
    }


}
