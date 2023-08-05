import FGA.ASCII;
import FGA.DeliveryCost;
import FGA.casting;

public class Main {
    public static void main(String[] args) {

//        new ASCII().printAsciiName();
//        new ASCII().printArtKucing();

//        DeliveryCost cost = new DeliveryCost();
//        System.out.println("Biaya:" + cost.rumusHarga(1000,1000,1000,100, 3));
//        cost.cetakHarga();

        casting c = new casting();
        c.castShortToAByte();
        System.out.println(c.b+1);
        System.out.println(c.b+1+1);
        c.causedError();
    }
}