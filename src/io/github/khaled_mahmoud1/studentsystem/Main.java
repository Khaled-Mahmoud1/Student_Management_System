package io.github.khaled_mahmoud1.studentsystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentDatabase db = new StudentDatabase();
        int choice;

        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll in Courses");
            System.out.println("3. Pay Tuition");
            System.out.println("4. Show Student Info");
            System.out.println("5. Show All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    db.addStudent();
                    break;
                case 2:
                    System.out.print("Enter student index (0,1,2...): ");
                    int indexEnroll = in.nextInt();
                    in.nextLine();
                    if (indexEnroll < db.getStudents().size()) {
                        db.getStudents().get(indexEnroll).enroll();
                    } else {
                        System.out.println("Invalid student index.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student index: ");
                    int indexPay = in.nextInt();
                    System.out.print("Enter amount to pay: ");
                    int amount = in.nextInt();
                    if (indexPay < db.getStudents().size()) {
                        db.getStudents().get(indexPay).payTuition(amount);
                    } else {
                        System.out.println("Invalid student index.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student index: ");
                    int indexInfo = in.nextInt();
                    if (indexInfo < db.getStudents().size()) {
                        System.out.println(db.getStudents().get(indexInfo).showInfo());
                    } else {
                        System.out.println("Invalid student index.");
                    }
                    break;
                case 5:
                    db.showAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        in.close();
    }
}
