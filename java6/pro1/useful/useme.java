package useful;
public class useme{
    public double area(double length, double width) {
        return length * width;
    }
    public double area(double radius) {
        return Math.PI * radius * radius;
    }
    public double salary(double basicPay, double hra, double da) {
        return basicPay + hra + da;
    }
    public double percentage(double obtainedMarks, double totalMarks) {
        if (totalMarks == 0) {
            return 0;
        }
        return (obtainedMarks / totalMarks) * 100;
    }
}