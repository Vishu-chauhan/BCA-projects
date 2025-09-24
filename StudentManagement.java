import java.util.*;

class Students {
    int rollNo;
    String name;
    String course;
    int marks;

    public Students(int rollNo, String name, String course, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course + ", Marks: " + marks;
    }
}

public class StudentManagement {
    static ArrayList<Students> students = new ArrayList<>();

    public static void addStudent(int roll, String name, String course, int marks) {
        students.add(new Students(roll, name, course, marks));
        System.out.println("Student Added Successfully!");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Students Found!");
        } else {
            for (Students s : students) {
                System.out.println(s);
            }
        }
    }

    public static void updateStudent(int roll, int marks) {
        for (Students s : students) {
            if (s.rollNo == roll) {
                s.marks = marks;
                System.out.println("Student Updated Successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    public static void deleteStudent(int roll) {
        boolean removed = students.removeIf(s -> s.rollNo == roll);
        if (removed) {
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine(); // Clear buffer
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Marks: ");
                    int marks = sc.nextInt();
                    sc.nextLine(); // Clear buffer
                    addStudent(roll, name, course, marks);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to Update: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine(); // Clear buffer
                    System.out.print("Enter New Marks: ");
                    int newMarks = sc.nextInt();
                    sc.nextLine(); // Clear buffer
                    updateStudent(rollNo, newMarks);
                    break;

                case 4:
                    System.out.print("Enter Roll No to Delete: ");
                    int delRoll = sc.nextInt();
                    sc.nextLine(); // Clear buffer
                    deleteStudent(delRoll);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
