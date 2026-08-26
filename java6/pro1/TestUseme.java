import useful.useme;
public class TestUseme {
    public static void main(String[] args) {
        useme helper = new useme();
        System.out.println("Area: " + helper.area(5, 4));
        System.out.println("Salary: " + helper.salary(50000, 10000, 5000));
        System.out.println("Percentage: " + helper.percentage(450, 500) + "%");
    }
}