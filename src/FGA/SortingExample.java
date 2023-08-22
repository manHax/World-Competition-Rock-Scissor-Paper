package FGA;

import java.util.*;

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
        int loop=0;
//        ArrayList<Integer> temp = new ArrayList<>();
//        ArrayList<Integer> temp2 = new ArrayList<>();
        List<String> winner = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8"));
        List<String> runner = new ArrayList<>(Arrays.asList("q","w","e","r","t","y","u","i"));
        List<String> allMember = new ArrayList<>();
        allMember.addAll(winner);
        allMember.addAll(runner);

        while ( loop< 16) {
            int tempInt = new Random().nextInt(allMember.size());
            int tempInt2 = new Random().nextInt(allMember.size());
            System.out.println(">> "+allMember.size()+" | "+tempInt+" "+tempInt2);
            if (tempInt+allMember.size()/2 != tempInt2 && tempInt2!=tempInt) {
//                System.out.println(tempInt+" "+allMember.get(tempInt));
//                System.out.println(tempInt2+" "+allMember.get(tempInt2));
                String player1=allMember.get(tempInt);
                String player2=allMember.get(tempInt2);
                allMember.remove(player1);
                allMember.remove(player2);
                System.out.println(player1+" Vs. "+player2);
                loop+=2;
//                System.out.println("\nWinner "+winner.get(tempInt));
//                loop+=2;
////                big16Member.add(winnerMember.get(tempInt));
//                winner.remove(tempInt);
//                System.out.println("Runner "+runner.get(tempInt2));
////                big16Member.add(runnerUpMember.get(tempInt2));
//                runner.remove(tempInt2);
            }
            //            System.out.println();
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
