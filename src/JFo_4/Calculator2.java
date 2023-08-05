package JFo_4;

public class    Calculator2 {
    public double tax = .05;
    public double tip = .15;  //Change tax and tip if you prefer different values
    public double originalPrice = 0;
    
    public void findTotal(){
        System.out.println("Total After Tax and Tip : "+(originalPrice*(1+tax+tip)));
        //Calculate an individual's total after tax and tip
        //Print this value
    }

    public static void main(String[] args) {
        int[] persons = { 10, 12, 9, 8, 7, 15, 11, 30 };
        for (int person : persons){
            Calculator2 calc = new Calculator2();
            calc.originalPrice=person;
            calc.findTotal();
        }
    }
}
