package worldcompetitionrockscissorpaper;

public class RockPaperScissor {
    static String[] rockPaperScissor= {"Rock","Paper","Scissor"};
    static void mengalahkan(Nation p1, Nation p2){
        p1.wins+=1;
        System.out.println(p1.name+" use : "+rockPaperScissor[p1.hand]+" Mengalahkan "+p2.name+" use : "+rockPaperScissor[p2.hand]);
    }
    static void combat(Nation p1, Nation p2){
        p1.setHand();p2.setHand();
        if (p1.hand==p2.hand){
            System.out.println(p1.name+" use :"+rockPaperScissor[p1.hand]+" "+p2.name+" use :"+rockPaperScissor[p2.hand]);
            System.out.println(p1.name+" Seimbang dengan "+p2.name);
        }
        if (p1.hand == 2 || p2.hand == 2) {
            if (p2.hand==0) {mengalahkan(p2,p1);return;}
            if (p1.hand==0) {mengalahkan(p1,p2);return;}
        }
        if (p1.hand > p2.hand){
            mengalahkan(p1,p2);
        } else if (p1.hand < p2.hand){
            mengalahkan(p2,p1);
        }
    }
    static void combatWithWins(Nation p1, Nation p2, int agr){
        p1.wins=0;
        p2.wins=0;
        int battleID=0;
        while (p1.wins<agr && p2.wins<agr){
            System.out.println("//////////////////////");
            System.out.println("Battle ke-"+battleID);
            combat(p1,p2);
            System.out.println("Kedudukan Sementara :");
            System.out.println(p1.name+" : "+p1.wins);
            System.out.println(p2.name+" : "+p2.wins);
            battleID++;
        }
        if (p1.wins==5){
            System.out.println(p1.name+" Menang");
        }else {
            System.out.println(p2.name+" Menang");

        }
    }

    public static void main(String[] args) {
        Nation p1 = new Nation("Sarah");
        Nation p2 = new Nation("Farah");
        combatWithWins(p1,p2,5);




//        Random rand = new Random();
//        Random rand2 = new Random();
//        int computer = rand.nextInt(3);
//        int user = rand2.nextInt(3);
//        combat(computer,user);

    }
}
