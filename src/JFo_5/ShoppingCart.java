package JFo_5;

public class ShoppingCart {

    public static void main(String[] args) {
        String custName = "Mary Smith";
        String itemDesc = "Shirt";

	// numeric fields
        double price = 21.99;
        int quantity = 2;
        double tax = 1.04;
        double total;
        boolean outOfStock=true;
	String message = custName+" wants to purchase "+quantity+" "+itemDesc;

	// Calculating total cost
        total = (price*quantity)*tax;

        
        // Declare outOfStock variable and initialize it
        if (quantity>1) {
            message = message.replace("purchase","purchases");
        }
        if (outOfStock){
            System.out.println("The item is unavailable");
        }else {
            System.out.println(message);
        }


        
        
        // Test quantity and modify message if quantity > 1.  
         
        
        // Test outOfStock and notify user in either case.  
        
        
        
    }
    
}


