package JFo_4;

public class Tip01 {
    public static Double countTax(int i){return (Double) (i*0.05);}
    public static Double countTip(int i){return (Double) (i*0.15);}
    public static Double countTotal(int before,double tax, double tip){return before+(tax+tip);}

    public static void main(String[] args) {
        //Find everyone's individual total after tax(5%) and tip(15%)
        /*This is what everyone owes before tax and tip:
        Person 1: $10
        Person 2: $12
        Person 3: $9
        Person 4: $8
        Person 5: $7
        Person 6: $15
        Person 7: $11
        Person 8: $30
        */
        int[] persons = { 10, 12, 9, 8, 7, 15, 11, 30 };
        for (int person : persons){
            System.out.println("Total after tax :"+countTotal(person,countTax(person),countTip(person)));
        }


    }    
}
