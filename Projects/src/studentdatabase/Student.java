package studentdatabase;

import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000;

    //Constructor: prompts user to enter name and year
    public Student(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student first name");
        this.firstName = scan.nextLine();
        System.out.println("Enter student last name");
        this.lastName = scan.nextLine();
        System.out.println("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = scan.nextInt();
        setStudentID();
        
    }
    
    //Generate ID
    private void setStudentID(){
        //Grade year + ID
        this.studentID = gradeYear + "" + id;
        id++;
    }
    
    //Enroll on courses
    public void enroll(){
        do{
            System.out.println("Enter course to enroll (Q to quit): ");
            Scanner scan = new Scanner(System.in);
            String course = scan.nextLine();
            if(!course.equals("Q")){
                courses += "\n  " + course;
                tuitionBalance += costOfCourse;
            }else{
                break;
            }
        }while(true);
        
    }
    //View balance
    public void viewBalance(){
        System.out.println("Your balance is: $" + tuitionBalance);
    }
    //Pay tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner scan = new Scanner(System.in);
        int payment = scan.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }
    //Show status
    public String showInfo(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: " + tuitionBalance;
    }
}
