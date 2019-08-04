package studentdatabase;

import java.util.Scanner;

public class StudentDatabaseApp {
    
    public static void main(String[] args){
        //Ask how many students we want to add
        System.out.print("Enter the number of students to enroll: ");
        Scanner scan = new Scanner(System.in);
        int numberOfStudents = scan.nextInt();
        //Create n number of students
        Student[] students = new Student[numberOfStudents];
        for(int n=0; n<numberOfStudents; n++){
        students[n] = new Student();
        students[n].enroll();
        students[n].payTuition();
        }
    }
    
}
