import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public student(String name, int rollNumber, String grade) 
{
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName()
 {
        return name;
    }

    public int getRollNumber()
 {
        return rollNumber;
    }

    public String getGrade()
 {
        return grade;
    }

    @Override
    public String toString()
 {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem
 {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student)
 {
        students.add(student);
    }

    public void removeStudent(int rollNumber) 
{
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) 
{
        for (Student student : students) 
{
            if (student.getRollNumber() == rollNumber)
 {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class StudentManagementSystemApp
 {
    public static void main(String[] args) 
{
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentSystem = new StudentManagementSystem();

        while (true) 
{
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
{
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    studentSystem.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Roll Number to Remove: ");
                    int removeRollNumber = scanner.nextInt();
                    studentSystem.removeStudent(removeRollNumber);
                    System.out.println("Student removed successfully.");
                    break;
                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRollNumber = scanner.nextInt();
                    Student searchResult = studentSystem.searchStudent(searchRollNumber);
                    if (searchResult != null) {
                        System.out.println("Student found:");
                        System.out.println(searchResult);
                    } else
 {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("All Students:");
                    studentSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
