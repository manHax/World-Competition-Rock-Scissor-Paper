package JFo_7;//Section 7, Lesson 5 Starter for Exercise 1 - Slide 10

import JFo_7.Prisoner_Student_7_5;

public class PrisonTest_Student_7_5 {
    public static void main(String[] args){
        
        Prisoner_Student_7_5 bubba = new Prisoner_Student_7_5("Bubba", 2.08, 4,new Cell("Nusa Kambangan",false,"123123123"));
        bubba.cell.modifyDoor("123123123");
    }
}
