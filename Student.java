public class Student {
    String name;
    int rollNo;
    String department;
    Student() {
        name = "Ram Verma";
        rollNo = 14;
        department = "Electronics";
    }
    Student(String n, int r, String d) {
        name = n;
        rollNo = r;
        department = d;
    }
    Student(Student s) {
        name = s.name;
        rollNo = s.rollNo;
        department = s.department;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + department);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Kamlesh", 1, "Computer");
        Student s3 = new Student(s1);
        System.out.println("Student 1:");
        s1.display();
        System.out.println();
        System.out.println("Student 2:");
        s2.display();
        System.out.println();
        System.out.println("Student 3:");
        s3.display();
    }
}
