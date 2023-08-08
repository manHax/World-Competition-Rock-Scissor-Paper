package WorldCompetitionRockScissorPaper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        List<String> countries = new ArrayList<>(Arrays.asList(
                "Argentina", "Australia", "Austria", "Belgium", "Bolivia",
                "Brazil", "Cameroon", "Canada", "Chile", "China PR", "Colombia",
                "Costa Rica", "Croatia", "Czech Republic", "Denmark", "Ecuador",
                "Egypt", "England", "Finland", "France", "Germany", "Greece",
                "Hungary", "India", "Indonesia", "Iran", "Iraq", "Italy", "Japan",
                "Mexico", "Netherlands", "New Zealand", "Nigeria", "Norway", "Paraguay",
                "Peru", "Poland", "Portugal", "Romania", "Russia", "Saudi Arabia",
                "Scotland", "Serbia", "Slovakia", "South Africa", "South Korea",
                "Spain", "Sweden", "Switzerland", "Turkey", "Ukraine", "United States",
                "Uruguay", "Wales"
        ));
        ArrayList<Integer> temp = new ArrayList<>();
        while (this.nations.size()<32){
            Random rand = new Random();
            int tempInt =rand.nextInt(54);
            if (!temp.contains(tempInt)) {
                addNations(new Nation(countries.get(tempInt)));
                temp.add(tempInt);
            }
        }

//        for (String nation : nations) {
//            addNations(new Nation(nation));
//            System.out.println(nations.size() + " " + nation);
//        }
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
