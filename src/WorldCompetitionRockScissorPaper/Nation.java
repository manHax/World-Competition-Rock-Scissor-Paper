package WorldCompetitionRockScissorPaper;

import java.util.Random;

public class Nation {
    String knockedOutAt;
    public int getPointGroup() {
        return pointGroup;
    }

    public void setPointGroup(int pointGroup) {
        this.pointGroup = pointGroup;
    }

    public int getPlayGroup() {
        return playGroup;
    }

    public void setPlayGroup(int playGroup) {
        this.playGroup = playGroup;
    }

    public int getWinsGroup() {
        return winsGroup;
    }

    public void setWinsGroup(int winsGroup) {
        this.winsGroup = winsGroup;
    }

    public int getDrawsGroup() {
        return drawsGroup;
    }

    public void setDrawsGroup(int drawsGroup) {
        this.drawsGroup = drawsGroup;
    }

    public int getLosesGroup() {
        return losesGroup;
    }

    public void setLosesGroup(int losesGroup) {
        this.losesGroup = losesGroup;
    }
    boolean winnerKnockOut = false;

    int pointGroup;
    int playGroup;
    int winsGroup;
    int drawsGroup;
    int losesGroup;
    int winsScore;
    String[] rockPaperScissor= {"Rock","Paper","Scissor"};
    public int wins;
    public int loses;
    public int getHand() {
        return hand;
    }

    public void setHand() {
        Random rand= new Random();
        this.hand = rand.nextInt(3);
        System.out.println("i'm from "+name+" menggunakan "+rockPaperScissor[this.hand]);
    }

    int hand ;
    String name;

    public Nation(String name) {
//        System.out.println(name);
        this.name=name;
    }
}