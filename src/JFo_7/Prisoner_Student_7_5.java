package JFo_7;//Section 7, Lesson 5 Starter for Exercise 1 - Slide 10

public class Prisoner_Student_7_5 {
    //Fields 
    public String name;
    public double height;
    public int sentence;
    Cell cell;
    
    //Constructor
    public Prisoner_Student_7_5(String name, double height, int sentence,Cell cell){
 	this.name = name;
 	this.height = height;
 	this.sentence = sentence;
     this.cell=cell;

    }
    
    //Methods
    public void think(){
        System.out.println("I'll have my revenge.");
    }
    public void display(boolean b){
        System.out.println("Name: " +name);
        System.out.println("Height: " +height);
        System.out.println("Sentence: " +sentence);
    }
    
}
