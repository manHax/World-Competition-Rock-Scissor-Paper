package JFo_4;

import java.util.Scanner;
import java.lang.Math;


public class ComputeBMI {
    public static void main(String[] args)
	{
        double weight = 132.5, height = 62.5;
        double BMI;
        BMI = Math.round(weight/Math.pow(height,2)*703);
        System.out.println("Your BMI "+BMI);


        }
}
