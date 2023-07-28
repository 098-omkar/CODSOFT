import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
    // Add any other relevant details here

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters for other attributes can be added if needed

    @Override
    public String toString() {
        return "Name: " + name + "\nRoll Number: " + rollNumber + "\nGrade: " + grade;
    }

    public int getRollNumber() {
        return 0;
    }

    public boolean getName() {
        return false;
    }

    public Object getGrade() {
        return null;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
            System.out.println("-------------------------");
        }
    }

    // Implement methods to read and write student data to a storage medium (e.g., file)
    // Here, I will show how to write student data to a file.

    public void writeStudentDataToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.println(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class StudentManagementSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        boolean running = true;
        while (running) {
            System.out.println("\n-- Student Management System --");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Save students to a file");
            System.out.println("6. Exit");
            System.out.println("---------------------\n");
            System.out.print("Enter your choice:   ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character from the buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter the student's name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter the roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine(); // Clear the newline character from the buffer
                        System.out.print("Enter the grade: ");
                        String grade = scanner.nextLine();

                        Student newStudent = new Student(name, rollNumber, grade);
                        system.addStudent(newStudent);
                        System.out.println("Student added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter the roll number of the student to remove: ");
                        int rollToRemove = scanner.nextInt();
                        scanner.nextLine(); // Clear the newline character from the buffer

                        Student studentToRemove = system.searchStudent(rollToRemove);
                        if (studentToRemove != null) {
                            system.removeStudent(studentToRemove);
                            System.out.println("Student removed successfully!");
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter the roll number of the student to search: ");
                        int rollToSearch = scanner.nextInt();
                        scanner.nextLine(); // Clear the newline character from the buffer

                        Student foundStudent = system.searchStudent(rollToSearch);
                        if (foundStudent != null) {
                            System.out.println("Student found:\n" + foundStudent);
                        } else {
                            System.out.println("Student not found!");
                        }
                        break;

                    case 4:
                        system.displayAllStudents();
                        break;

                    case 5:
                        System.out.print("Enter the file name to save student data: ");
                        String fileName = scanner.nextLine();
                        system.writeStudentDataToFile(fileName);
                        System.out.println("Student data saved to " + fileName + " successfully!");
                        break;

                    case 6:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input from the buffer
            }
        }

        scanner.close();
        System.out.println("Exiting the Student Management System.");
    }
}
