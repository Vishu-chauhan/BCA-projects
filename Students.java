public class Students {
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
