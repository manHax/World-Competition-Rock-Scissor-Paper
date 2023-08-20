package WorldCompetitionRockScissorPaper;

import WorldCompetitionRockScissorPaper.JDBC.JdbcConnection;

import java.sql.SQLException;
import java.util.Date;

public class Match {
    JdbcConnection myDB = new JdbcConnection();

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

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

    public void matchResult(Nation p1, Nation p2) throws SQLException, ClassNotFoundException {
        if (p1.wins == p2.wins) {
            p1.setPointGroup(p1.pointGroup += 1);
            p2.setPointGroup(p2.pointGroup += 1);
            p1.setDrawsGroup(p1.drawsGroup += 1);
            p2.setDrawsGroup(p2.drawsGroup += 1);
            myDB.setResultMatch(this.matchId,"DRAW",p1.wins, p2.wins);
            System.out.println("\nHasil Seri Pada match ini");
        } else if (p1.wins > p2.wins) {
            p1.setWinsGroup(p1.winsGroup += 1);
            p2.setLosesGroup(p2.losesGroup += 1);
            p1.setPointGroup(p1.pointGroup += 3);
            myDB.setResultMatch(this.matchId,p1.name,p1.wins, p2.wins);
            System.out.println("\nMatch dimenangkan " + p1.name);
        } else {
            p2.setWinsGroup(p2.winsGroup += 1);
            p1.setLosesGroup(p1.losesGroup += 1);
            p2.setPointGroup(p2.pointGroup += 3);
            myDB.setResultMatch(this.matchId,p2.name,p1.wins, p2.wins);
            System.out.println("\nMatch dimenangkan " + p2.name);
        }
    }

    public void combatWithWins(Nation p1, Nation p2, int agr) throws SQLException, ClassNotFoundException {
        p1.wins = 0;
        p1.loses = 0;
        p2.loses = 0;
        p2.wins = 0;
        int battleID = 1;
        if (agr != 5) {
            for (int i = 0; i < agr; i++) {
                System.out.println("\n//////////////////////");
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
                System.out.println("\n//////////////////////");
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

    public void startMatch() throws SQLException, ClassNotFoundException {
        System.out.println("\n>> Start " + matchId+" <<");
        System.out.println(player1.name+" vs " + player2.name);
        System.out.println("Battle Start on " + matchDate);
        player1.setPlayGroup(player1.playGroup+=1);
        player2.setPlayGroup(player2.playGroup+=1);
        this.combatWithWins(player1, player2, 7);
        myDB.updateNations(player1);
        myDB.updateNations(player2);
    }

    public Nation startKnockOutMatch() throws SQLException, ClassNotFoundException {
        System.out.println("\n>> Start " + matchId+" <<");
        System.out.println(player1.name+" vs " + player2.name);
        System.out.println("Battle Start on " + matchDate);
        this.combatWithWins(player1, player2, 5);
        myDB.updateNations(player1);
        myDB.updateNations(player2);
        Nation knockedOut = player1.winnerKnockOut? player2 :player1;
        myDB.setNationAsKnockout(knockedOut,matchId);
        return knockedOut;
    }
}
