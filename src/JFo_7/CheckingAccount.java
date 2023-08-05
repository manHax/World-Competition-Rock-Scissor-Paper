package JFo_7;

public class CheckingAccount {
    long balance;
    String name;

    public void withdraw(double amount){
        System.out.println("your balance : "+this.balance);
        if (this.balance-amount < 0 ){
            System.out.println("insufficient balance");
        }
        else if (amount < 0){
            System.out.println("amount cant be negative");
        } else {
            this.balance= (long) (balance-amount);
            System.out.println("withdraw successfully ");
            System.out.println("balance now : "+balance);
        }
    }
}
