package WorldCompetitionRockScissorPaper;

import java.util.*;

public class Group {
    Nation winner = null;
    Nation runnerUp = null;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public void setGroupMember(List<Nation> groupMember) {
        this.groupMember = groupMember;
    }

    String groupName;

    public List<Match> getGroupMatch() {
        return groupMatch;
    }

    private void setGroupMatch(Match match) {
        this.groupMatch.add(match);
    }

    List<Match> groupMatch = new ArrayList<>();
    List<Nation> groupMember;

    public List<Nation> getGroupMember() {
        return groupMember;
    }


    public Group(String groupName, List<Nation> groupMember) {
        this.groupName = groupName;
        this.groupMember = groupMember;
        this.groupMember = this.groupMember;
        System.out.println(groupName);
        for (Nation na : groupMember) {
            System.out.println("> "+na.name);
        }
    }

    public String getClassement() {
        System.out.println("++++++++++++++++++++++++++++++");
        for (Nation nation : groupMember) {
            System.out.println(">> " + nation.name);
            System.out.println("Point : " + nation.getPointGroup());
            System.out.println("Skors : " + nation.winsScore);
            System.out.println("Wins : " + nation.getWinsGroup());
            System.out.println("Draws : " + nation.getDrawsGroup());
            System.out.println("Loses : " + nation.getLosesGroup());
            System.out.println("");
        }
        return null;
    }

    public List<Nation> getWinnerAndRunnerUp() {
        List<Nation> winnerAndRunnerUp = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < groupMember.size(); i++) {
            list1.add(i);
            list2.add(groupMember.get(i).pointGroup);
            list3.add(groupMember.get(i).winsScore);

        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println("");

        // Membuat indeks baru yang menyimpan posisi asli dari setiap elemen
        Integer[] indexes = new Integer[list1.size()];
        Integer[] indexes2 = new Integer[list1.size()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
            indexes2[i] = i;
        }

        // Mengurutkan indeks berdasarkan nilai di list1
        Arrays.sort(indexes, Comparator.comparingInt(list2::get));
        Arrays.sort(indexes2, Comparator.comparingInt(list3::get));
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list1);
        System.out.println(list3);
        System.out.println("");

        // Membuat List baru dengan posisi yang diurutkan
        List<Integer> sortedList1 = new ArrayList<>();
        List<Integer> sortedList2 = new ArrayList<>();
        List<Integer> sortedList1b = new ArrayList<>();
        List<Integer> sortedList3 = new ArrayList<>();
        for (int i = 0; i < indexes.length; i++) {
            sortedList1.add(list1.get(indexes[i]));
            sortedList2.add(list2.get(indexes[i]));
            sortedList1b.add(list1.get(indexes2[i]));
            sortedList3.add(list3.get(indexes2[i]));
        }

        // Menampilkan list yang sudah diurutkan
        System.out.println(sortedList1);
        System.out.println(sortedList2);
        System.out.println(sortedList1b);
        System.out.println(sortedList3);

        if (Objects.equals(sortedList2.get(3), sortedList2.get(2))) {
            System.out.println("comparing wins score");
            if (Objects.equals(sortedList3.get(3), sortedList3.get(2))) {
                System.out.println("nothing to compare!\nusing default");
                winnerAndRunnerUp.add(groupMember.get(sortedList1b.get(3)));
                winnerAndRunnerUp.add(groupMember.get(sortedList1b.get(2)));
                winner = groupMember.get(sortedList1b.get(3));
                runnerUp = groupMember.get(sortedList1b.get(2));
            } else {
                winnerAndRunnerUp.add(groupMember.get(sortedList1b.get(3)));
                winnerAndRunnerUp.add(groupMember.get(sortedList1b.get(2)));
                winner = groupMember.get(sortedList1b.get(3));
                runnerUp = groupMember.get(sortedList1b.get(2));
            }
        } else {
            winnerAndRunnerUp.add(groupMember.get(sortedList1.get(3)));
            winnerAndRunnerUp.add(groupMember.get(sortedList1.get(2)));
            winner = groupMember.get(sortedList1.get(3));
            runnerUp = groupMember.get(sortedList1.get(2));
        }
        System.out.println("winner " + groupName + " is " + winnerAndRunnerUp.get(0).name);
        System.out.println("runner up " + groupName + " is " + winnerAndRunnerUp.get(1).name);
        return winnerAndRunnerUp;
    }

    public Nation getRunnerUp() {
        System.out.println("++++++++++++++++++++++++++++++");
        for (Nation nation : groupMember) {
            System.out.println(">> " + nation.name);
            System.out.println("Point : " + nation.getPointGroup());
            System.out.println("Wins : " + nation.getWinsGroup());
            System.out.println("Draws : " + nation.getDrawsGroup());
            System.out.println("Loses : " + nation.getLosesGroup());
            System.out.println("");
        }
        return null;
    }

    public Nation getWinner() {
        List<Integer> memberId = new ArrayList<>();
        System.out.println("++++++++++++++++++++++++++++++");

        for (int i = 0; i < groupMember.size(); i++) {
            System.out.println(groupMember.get(i) + " - " + i);
//            System.out.println(">> "+groupMember.get(i).name);
//            System.out.println("Point : "+groupMember.get(i).getPointGroup());
//            System.out.println("Wins : "+groupMember.get(i).getWinsGroup());
//            System.out.println("Draws : "+groupMember.get(i).getDrawsGroup());
//            System.out.println("Loses : "+groupMember.get(i).getLosesGroup());
//            System.out.println("");
            if (i == 0) {
                winner = groupMember.get(i);
            } else if (winner.getPointGroup() < groupMember.get(i).getPointGroup()) {
                winner = groupMember.get(i);
            } else if (winner.getPointGroup() == groupMember.get(i).getPointGroup()) {
                memberId.add(i);
            }
            System.out.println(winner.getPointGroup() + " = " + winner.name);
            System.out.println(groupMember.get(i).getPointGroup() + " - " + groupMember.get(i).name);
        }
        if (!memberId.isEmpty()) {
            System.out.println(memberId.size());
            for (int i : memberId) {
                System.out.println(winner.getPointGroup() + " = " + winner.name);
                System.out.println(groupMember.get(i).getPointGroup() + " - " + groupMember.get(i).name);
                if (winner.getPointGroup() < groupMember.get(i).getPointGroup()) {
                    winner = groupMember.get(i);
                } else if (winner.winsScore < groupMember.get(i).winsScore) {
                    winner = groupMember.get(i);
                }
            }

        }
        System.out.println("the winner of the group " + winner.name);
        return null;
    }


    public void matchMaking() {
        int player1 = 0;
        int player2 = 1;
        for (int i = 0; i < 6; i++) {

            player2++;
            if (player2 > 3) {
                player1++;
                player2 = player1 + 1;
            }
        }
    }

    public void doGroupFase() {
        int player1 = 0;
        int player2 = 1;
        for (int i = 0; i < 6; i++) {
            setGroupMatch(new Match(groupName + " Match ke-" + (i + 1), getGroupMember().get(player1), getGroupMember().get(player2), new Date()));
            player2++;
            if (player2 > 3) {
                player1++;
                player2 = player1 + 1;
            }
        }
    }

}
