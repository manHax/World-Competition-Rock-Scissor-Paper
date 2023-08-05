package FGA;

public class Parsing01 {
    public static void main(String[] args) {
        //Declare and intitialize 3 Strings:
        String shirtPrice="15", taxRate="0.05", gibberish="100LP90PO10PL";

        
        
        
        
        //Parse shirtPrice and taxRate, and print the total tax
        System.out.println("Total tax = "+(Integer.parseInt(shirtPrice)*Float.parseFloat(taxRate)));
        
        
        //Try to parse taxRate as an int
//        int tR = Integer.parseInt(taxRate);
        
        //Try to parse gibberish as an int
        int g = Integer.parseInt(gibberish);
        System.out.println(g+g);
        
    }
    
}
