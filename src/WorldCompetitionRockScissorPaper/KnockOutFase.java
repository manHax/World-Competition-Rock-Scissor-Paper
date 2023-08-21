package WorldCompetitionRockScissorPaper;

import WorldCompetitionRockScissorPaper.JDBC.JdbcConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KnockOutFase {
    JdbcConnection myDB = new JdbcConnection();

    public String getFaseName(int i) {
        if (big16Member.size() == 2) return "Final Round ";
        if (big16Member.size() == 16) return "Eight Final Round " + i;
        if (big16Member.size() == 8) return "Quarter Final Round " + i;
        if (big16Member.size() == 4) return "Semi Final Round " + i;
        return null;
    }

    public void setFaseName(String faseName) {
        this.faseName = faseName;
    }

    String faseName;

    public List<Match> getEightFinalMatchs() {
        return eightFinalMatchs;
    }

    public void setEightFinalMatchs(Match match) {
        this.eightFinalMatchs.add(match);
    }

    public void setThirdPotitionMatch(Match match) {
        this.thirdPotitionMatch.add(match);
    }

    List<Match> eightFinalMatchs = new ArrayList<>();
    List<Match> thirdPotitionMatch = new ArrayList<>();
    //    List<Match> quarterFinalMatchs = new ArrayList<>();
//    List<Match> semiFinalMatchs = new ArrayList<>();
//    List<Match> grandFinalMatchs = new ArrayList<>();
    List<Nation> big16Member = new ArrayList<>();
    List<Nation> thirdPlaceMember = new ArrayList<>();
    //    List<Nation> quarterFinalMember = new ArrayList<>();
//    List<Nation> semiFinalMember = new ArrayList<>();
//    List<Nation> grandFinalMember = new ArrayList<>();
    List<Nation> knockOutMember;

    public KnockOutFase(List<Nation> winnerMember, List<Nation> runnerUpMember) {
        for (int i = 0; i < runnerUpMember.size(); i++) {
            big16Member.add(winnerMember.get(i));
            big16Member.add(runnerUpMember.get(i));
        }
//        System.out.println(big16Member.size());

    }

    public void doKnockOutBig16Fase() throws SQLException, ClassNotFoundException {
        this.eightFinalMatchs = new ArrayList<>();
        if (thirdPlaceMember.size() == 2) {
            setThirdPotitionMatch(new Match("Third Place Match", thirdPlaceMember.get(0), thirdPlaceMember.get(1), new Date()));
            myDB.insertMatch(thirdPlaceMember.get(0).name, thirdPlaceMember.get(1).name, "Third Place Match", new java.sql.Date(new Date().getTime()));
        }
        for (int i = 0; i < big16Member.size(); i += 2) {
            setEightFinalMatchs(new Match(getFaseName(i == 0 ? i + 1 : i/2+1), big16Member.get(i), big16Member.get(i + 1), new Date()));
            myDB.insertMatch(big16Member.get(i).name, big16Member.get(i + 1).name, getFaseName(i == 0 ? i + 1 : i/2+1), new java.sql.Date(new Date().getTime()));
        }
//        System.out.println(getEightFinalMatchs().size());
//        int lenghtWinnerMember = big16Member.size();
    }
}
