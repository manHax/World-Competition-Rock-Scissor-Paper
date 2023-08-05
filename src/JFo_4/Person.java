package JFo_4;

import java.util.Random;

public class Person{
    String[] rockPaperScissor= {"Rock","Paper","Scissor"};
    public int age;
    public int wins;
    public int getHand() {
        return hand;
    }

    public void setHand() {
        Random rand= new Random();
        this.hand = rand.nextInt(3);
        System.out.println("aku "+name+" menggunakan "+rockPaperScissor[this.hand]);
    }

    int hand ;
    String name;

    public Person(String name) {
        System.out.println("namaku "+name);
        this.name=name;
    }
}