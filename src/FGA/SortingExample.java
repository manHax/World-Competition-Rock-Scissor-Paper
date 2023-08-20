package FGA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class SortingExample {
    public static void main(String[] args) {
        for (;;) {
            System.out.println("Welcome to Java");
        }
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student("Alice", 22));
//        students.add(new Student("Bob", 20));
//        students.add(new Student("Claude", 25));
//
//        System.out.println("Before sorting: " + students);
//
////        Collections.sort(students, Comparator.comparing(Student::getAge));
//        Collections.sort(students, (s1, s2) -> {
//            return Integer.compare(s2.getAge(), s1.getAge()); // Compare ages in reverse order
//        });
//
//        for (Student s : students) {
//            System.out.println("After sorting by name: " + s.getAge());
//
//        }
    }
}
