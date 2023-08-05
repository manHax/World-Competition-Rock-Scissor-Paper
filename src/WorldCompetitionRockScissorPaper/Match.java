package WorldCompetitionRockScissorPaper;

import java.util.Date;

public class Match {
    String matchId;
    Date matchDate;
    Nation player1;
    Nation player2;

    public Match(String matchId, Nation player1, Nation player2, Date matchDate) {
        this.matchDate = matchDate;
        this.matchId = matchId;
        this.player1 = player1;
        this.player2 = player2;
    }

    public String[] rockPaperScissor = {"Rock", "Paper", "Scissor"};

    public void mengalahkan(Nation p1, Nation p2) {
        p1.wins += 1;
        p2.loses += 1;
        System.out.println(p1.name + " use : " + rockPaperScissor[p1.hand] + " Mengalahkan " + p2.name + " use : " + rockPaperScissor[p2.hand]);
    }

    public void combat(Nation p1, Nation p2) {
        p1.setHand();
        p2.setHand();
        if (p1.hand == p2.hand) {
            System.out.println(p1.name + " use :" + rockPaperScissor[p1.hand] + " " + p2.name + " use :" + rockPaperScissor[p2.hand]);
            System.out.println(p1.name + " Seimbang dengan " + p2.name);
        }
        if (p1.hand == 2 || p2.hand == 2) {
            if (p2.hand == 0) {
                mengalahkan(p2, p1);
                return;
            }
            if (p1.hand == 0) {
                mengalahkan(p1, p2);
                return;
            }
        }
        if (p1.hand > p2.hand) {
            mengalahkan(p1, p2);
        } else if (p1.hand < p2.hand) {
            mengalahkan(p2, p1);
        }
    }

    public void matchResult(Nation p1, Nation p2) {
        if (p1.wins == p2.wins) {
            p1.setPointGroup(p1.pointGroup += 1);
            p2.setPointGroup(p2.pointGroup += 1);
            p1.setDrawsGroup(p1.drawsGroup += 1);
            p2.setDrawsGroup(p2.drawsGroup += 1);
            System.out.println("\nHasil Seri Pada match ini");
        } else if (p1.wins > p2.wins) {
            p1.setWinsGroup(p1.winsGroup += 1);
            p2.setLosesGroup(p2.losesGroup += 1);
            p1.setPointGroup(p1.pointGroup += 3);
            System.out.println("\nMatch dimenangkan " + p1.name);
        } else {
            p2.setWinsGroup(p2.winsGroup += 1);
            p1.setLosesGroup(p1.losesGroup += 1);
            p2.setPointGroup(p2.pointGroup += 3);
            System.out.println("\nMatch dimenangkan " + p2.name);
        }
    }

    public void combatWithWins(Nation p1, Nation p2, int agr) {
        p1.wins = 0;
        p1.loses = 0;
        p2.loses = 0;
        p2.wins = 0;
        int battleID = 1;
        if (agr != 5) {
            for (int i = 0; i < agr; i++) {
                System.out.println("//////////////////////");
                System.out.println("Battle ke-" + battleID);
                combat(p1, p2);
                battleID++;
                if (i < 7) {
                    System.out.println("Kedudukan Sementara :");
                    System.out.println(p1.name + " : " + p1.wins);
                    System.out.println(p2.name + " : " + p2.wins);
                }
            }
            System.out.println(p1.wins + " - " + p1.loses);
            System.out.println(p2.wins + " - " + p2.loses);
            p1.winsScore += p1.wins - p1.loses;
            p2.winsScore += p2.wins - p2.loses;
            System.out.println(p1.name + " scors = " + p1.winsScore);
            System.out.println(p2.name + " scors = " + p2.winsScore);
            matchResult(p1, p2);
        } else {
            while (p1.wins < agr && p2.wins < agr) {
                System.out.println("//////////////////////");
                System.out.println("Battle ke-" + battleID);
                combat(p1, p2);
                System.out.println("Kedudukan Sementara :");
                System.out.println(p1.name + " : " + p1.wins);
                System.out.println(p2.name + " : " + p2.wins);
                battleID++;
            }
            if (p1.wins == 5) {
                p1.winnerKnockOut=true;
                System.out.println(p1.name + " Menang");
            } else if (p2.wins == 5) {
                p2.winnerKnockOut=true;
                System.out.println(p2.name + " Menang");
            }
        }
    }

    public void startMatch() {
        System.out.println("\nStart " + matchId);
        System.out.println(player1.name+" vs " + player2.name);
        System.out.println("Battle Start on " + matchDate);
        this.combatWithWins(player1, player2, 7);
    }

    public Nation startKnockOutMatch() {
        System.out.println("\nStart " + matchId);
        System.out.println(player1.name+" vs " + player2.name);
        System.out.println("Battle Start on " + matchDate);
        this.combatWithWins(player1, player2, 5);

        return player1.winnerKnockOut? player2 :player1;
    }
}
