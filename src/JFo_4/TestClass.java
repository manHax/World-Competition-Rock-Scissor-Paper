package JFo_4;

public class TestClass {
    public static void main(String[] args) {
        ComputeMethods cm = new ComputeMethods();
        System.out.println("Temp in celsius "+cm.FahrenheitToCelsius(100));
        System.out.println("Hypotenuse is "+cm.hypotenuseLengthC(1,2));
        System.out.println("The sum of the dice values is "+cm.roll());
    }
}
