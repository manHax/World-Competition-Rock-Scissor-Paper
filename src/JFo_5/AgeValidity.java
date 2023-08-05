package JFo_5;

import JFo_4.Person;

import java.util.Scanner;


public class AgeValidity {

    public static void main(String[] args) {
        Person p1 = new Person("maman");
        p1.age = 18;
        boolean drivingUnderAge =false;
        if (p1.age<=18){
            drivingUnderAge=true;
        }
        System.out.println(drivingUnderAge);

       
    }
}
