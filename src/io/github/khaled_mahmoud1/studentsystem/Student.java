package io.github.khaled_mahmoud1.studentsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int gradeYear;
    private String studentID;
    private final List<String> courses = new ArrayList<>();
    private int tuitionBalance = 0;
    private static final int COST_OF_COURSE = 300;
    private static int id = 1000;

    // Constructor
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter Last Name: ");
        this.lastName = in.nextLine();
        System.out.println("1 - Freshman \n2 - Sophomore \n3 - Junior \n4 - Senior");
        System.out.print("Enter Student Class Level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
        System.out.println("Student Created: " + firstName + " " + lastName + " | Year: " + gradeYear + " | ID: " + studentID);
    }

    // Generate an ID
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll() {
        Scanner in = new Scanner(System.in);
        String course;
        do {
            System.out.print("Enter course to enroll (Q to quit): ");
            course = in.nextLine();
            if (!course.equalsIgnoreCase("Q")) {
                courses.add(course);
                tuitionBalance += COST_OF_COURSE;
                System.out.println("Enrolled in: " + course);
            }
        } while (!course.equalsIgnoreCase("Q"));
    }

    // View balance
    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition(int payment) {
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    // Show student info
    public String showInfo() {
        return "\nName: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses Enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
