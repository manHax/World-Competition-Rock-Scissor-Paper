package WorldCompetitionRockScissorPaper;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    List<Nation> nations;
    List<Group> groups;
    List<Nation> winnerAllGroup = new ArrayList<>();
    List<Nation> runnerUpAllGroup = new ArrayList<>();
    Nation champion;
    Nation runnerUp;
    Nation thirdPlace;


    public List<Group> getGroups() {
        return groups;
    }

    public void addGroups(Group groups) {
        this.groups.add(groups);
    }

    public Competition() {
        nations = new ArrayList<>();
        groups = new ArrayList<>();
        this.generateNations();
        this.generateGroup();
    }

    public List<Nation> getNations() {
        return nations;
    }

    public void addNations(Nation nation) {
        this.nations.add(nation);
    }

    public void generateNations() {
        ArrayList<String> asiaCountries = new ArrayList<>();
        asiaCountries.add("Afghanistan");
        asiaCountries.add("Armenia");
        asiaCountries.add("Azerbaijan");
        asiaCountries.add("Bahrain");
        asiaCountries.add("Bangladesh");
        asiaCountries.add("Bhutan");
        asiaCountries.add("Brunei");
        asiaCountries.add("Cambodia");
        asiaCountries.add("China");
        asiaCountries.add("Georgia");
        asiaCountries.add("India");
        asiaCountries.add("Indonesia");
        asiaCountries.add("Iran");
        asiaCountries.add("Iraq");
        asiaCountries.add("Israel");
        asiaCountries.add("Japan");
        asiaCountries.add("Jordan");
        asiaCountries.add("Kazakhstan");
        asiaCountries.add("Kuwait");
        asiaCountries.add("Kyrgyzstan");
        asiaCountries.add("Laos");
        asiaCountries.add("Lebanon");
        asiaCountries.add("Malaysia");
        asiaCountries.add("Maldives");
        asiaCountries.add("Mongolia");
        asiaCountries.add("Myanmar (Burma)");
        asiaCountries.add("Nepal");
        asiaCountries.add("North Korea");
        asiaCountries.add("Oman");
        asiaCountries.add("Pakistan");
        asiaCountries.add("Palestine");
        asiaCountries.add("Philippines");

        for (String nation : asiaCountries) {
            addNations(new Nation(nation));
            System.out.println(asiaCountries.size() + " " + nation);
        }
//        for (int i = 0; i < 32; i++) {
//            addNations(new Nation("Nation "+i));
//        }
    }

    public void generateGroup() {
        String[] stag = "A,B,C,D,E,F,G,H".split(",");
        for (int i = 0; i < 32; i += 4) {
            int j = i + 4;
            addGroups(new Group("Group " + stag[i / 4], nations.subList(i, j)));
        }
    }

    public void setKnockOutfase(Nation winner, Nation runnerUp) {
        this.winnerAllGroup.add(winner);
        this.runnerUpAllGroup.add(runnerUp);
    }

    public void doKnockOutFase(KnockOutFase kc) {
//        KnockOutFase kc = new KnockOutFase(this.winnerAllGroup,runnerUpAllGroup);
        kc.doKnockOutBig16Fase();
        if (kc.thirdPlaceMember.size() == 2) {
            for (Match match : kc.thirdPotitionMatch) {
                Nation knokedOut = match.startKnockOutMatch();
                kc.thirdPlaceMember.remove(knokedOut);
                this.thirdPlace=kc.thirdPlaceMember.get(0);
            }
        }
        if (kc.big16Member.size() == 4){
            for (Match match : kc.eightFinalMatchs) {
                Nation knokedOut = match.startKnockOutMatch();
                kc.thirdPlaceMember.add(knokedOut);
                kc.big16Member.remove(knokedOut);
            }
            doKnockOutFase(kc);
        }
        else
            if (kc.big16Member.size() == 2) {
            System.out.println("FINAL MATCH");
            for (Match match : kc.eightFinalMatchs) {
                Nation knokedOut = match.startKnockOutMatch();
                this.runnerUp=knokedOut;
                kc.big16Member.remove(knokedOut);
                this.champion=kc.big16Member.get(0);
            }
        } else {
            for (Match match : kc.eightFinalMatchs) {
                Nation knokedOut = match.startKnockOutMatch();
                kc.big16Member.remove(knokedOut);
                System.out.println("KNOCKEDOUT " + knokedOut.name);
                match.player2.winnerKnockOut=false;
                match.player1.winnerKnockOut=false;
                System.out.println(match.player1.winnerKnockOut+" "+match.player2.winnerKnockOut);
            }
            System.out.println("NATIONS LEFT : " + kc.big16Member.size());
            doKnockOutFase(kc);
        }
    }

    public static void main(String[] args) {
        Competition c = new Competition();
//        List<Nation> nations = c.getNations();
        List<Group> groups = c.getGroups();

        for (Group group : groups) {
            group.doGroupFase();
            for (Match match : group.groupMatch) {
                match.startMatch();
            }
            group.getClassement();
            group.getWinnerAndRunnerUp();

            c.setKnockOutfase(group.winner, group.runnerUp);
            System.out.println("WINNER " + group.winner.name);
            System.out.println("RUNNERUP " + group.runnerUp.name);
        }
        KnockOutFase kc = new KnockOutFase(c.winnerAllGroup, c.runnerUpAllGroup);
        c.doKnockOutFase(kc);
        System.out.println("\n**************************");
        System.out.println("Champion : "+c.champion.name);
        System.out.println("Runner Up : "+c.runnerUp.name);
        System.out.println("Third Place : "+c.thirdPlace.name);
        System.out.println("**************************");



//        kc.doKnockOutBig16Fase();
//        for (Match match : kc.eightFinalMatchs) {
//            Nation knokedOut =match.startKnockOutMatch();
//            kc.big16Member.remove(knokedOut);
//            System.out.println("KNOCKEDOUT "+knokedOut.name);
//        }
//        System.out.println("<><><>"+kc.big16Member.size());
//        kc.doKnockOutBig16Fase();
//        for (Match match : kc.eightFinalMatchs) {
//            Nation knokedOut = match.startKnockOutMatch();
//            kc.big16Member.remove(knokedOut);
//            System.out.println("KNOCKEDOUT " + knokedOut.name);
//        }
//        System.out.println("<><><>" + kc.big16Member.size());
//        kc.doKnockOutBig16Fase();
//        for (Match match : kc.eightFinalMatchs) {
//            Nation knokedOut = match.startKnockOutMatch();
//            kc.big16Member.remove(knokedOut);
//            System.out.println("KNOCKEDOUT " + knokedOut.name);
//        }
//        System.out.println("<><><>" + kc.big16Member.size());
//        kc.doKnockOutBig16Fase();
//        for (Match match : kc.eightFinalMatchs) {
//            Nation knokedOut = match.startKnockOutMatch();
//            kc.big16Member.remove(knokedOut);
//            System.out.println("KNOCKEDOUT " + knokedOut.name);
//        }
//        System.out.println("<><><>" + kc.big16Member.size());


//        Nation n = kc.eightFinalMatchs.get(0).startKnockOutMatch();
//        System.out.println(">>> " + n.name);

//        Group g1 = groups.get(0);
//        System.out.println(g1.groupName+" "+g1.winner.name);


    }
}
