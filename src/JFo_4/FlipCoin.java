package JFo_4;

import java.util.Random;

public class FlipCoin {

    public static void main(String[] args) {

        // 50% chance heads, 50% chance tails
        Random rand = new Random();
        double chance = rand.nextDouble();
        System.out.println(chance<0.5?"head":"tails");
        System.out.println(chance);
        }
    }

