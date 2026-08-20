import java.util.Scanner;
interface FY {
    void getFY();
    void showFY();
}
interface SY {
    void getSY();
    void showSY();
}
class Student implements FY, SY {
    int r1, r2;
    String n1, n2;
    double res1, res2;
    Scanner sc = new Scanner(System.in);
    public void getFY() {
        System.out.print("Enter FY Roll, Name, Result: ");
        r1 = sc.nextInt();
        n1 = sc.next();
        res1 = sc.nextDouble();
    }
    public void showFY() {
        System.out.println("FY: " + r1 + " " + n1 + " " + res1);
    }
    public void getSY() {
        System.out.print("Enter SY Roll, Name, Result: ");
        r2 = sc.nextInt();
        n2 = sc.next();
        res2 = sc.nextDouble();
    }
    public void showSY() {
        System.out.println("SY: " + r2 + " " + n2 + " " + res2);
    }
}
public class exp3{
    public static void main(String[] args) {
        Student s = new Student();
        s.getFY();
        s.getSY();
        s.showFY();
        s.showSY();
    }
}