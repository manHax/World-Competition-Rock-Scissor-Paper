package JFo_7;

public class AccountTest {


    public static void main(String[] args) {
        CheckingAccount ck = new CheckingAccount();
        ck.name="Geto Suguru";
        ck.balance=10000;
        ck.withdraw(-100000);
    }
}
