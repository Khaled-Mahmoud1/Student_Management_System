package io.github.khaled_mahmoud1.studentsystem;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    private final List<Student> students = new ArrayList<>();

    // Add student
    public void addStudent() {
        Student student = new Student();
        students.add(student);
    }

    // Show all students
    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled yet.");
        } else {
            for (Student s : students) {
                System.out.println(s.showInfo());
                System.out.println("==================================");
            }
        }
    }

    // Get all students
    public List<Student> getStudents() {
        return students;
    }
}
