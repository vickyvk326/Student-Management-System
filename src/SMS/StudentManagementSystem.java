package SMS;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. View all students");
            System.out.println("4. Quit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student grade: ");
        int grade = scanner.nextInt();
        Student student = new Student(name, id, grade);
        students.add(student);
        System.out.println("Student added.");
    }

    public static void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                System.out.println("Student removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void viewAllStudents() {
        if (students.size() == 0) {
            System.out.println("No students.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
        }
    }

}

class Student {

    private String name;
    private String id;
    private int grade;

    public Student(String name, String id, int grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Grade: " + grade;
    }

}