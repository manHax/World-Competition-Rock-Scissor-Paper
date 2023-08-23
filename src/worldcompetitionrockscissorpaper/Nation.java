package worldcompetitionrockscissorpaper;

import java.util.Random;

public class Nation {
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    String groupName;
    public String getKnockedOutAt() {
        return knockedOutAt;
    }

    public void setKnockedOutAt(String knockedOutAt) {
        this.knockedOutAt = knockedOutAt;
    }

    public int getWinsScore() {
        return winsScore;
    }

    public void setWinsScore(int winsScore) {
        this.winsScore = winsScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        this.hand = new Random().nextInt(3);
        System.out.println("i'm from "+name+" menggunakan "+rockPaperScissor[this.hand]);
    }

    int hand ;
    String name;

    public Nation(String name) {
        this.name=name;
    }
}