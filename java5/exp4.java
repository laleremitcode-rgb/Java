class Employee {
    String name;
    double salary;
}
class Manager extends Employee {
    double bonus;
    void show() {
        System.out.println("Manager: " + name + " | Salary: " + salary + " | Bonus: " + bonus);
    }
}
class Clerk extends Employee {
    double allowance;
    void show() {
        System.out.println("Clerk: " + name + " | Salary: " + salary + " | Allowance: " + allowance);
    }
}
public class exp4{
    public static void main(String[] args) {
        Manager m = new Manager();
        m.name = "Alice";
        m.salary = 80000;
        m.bonus = 15000;
        m.show();

        Clerk c = new Clerk();
        c.name = "Bob";
        c.salary = 40000;
        c.allowance = 5000;
        c.show();
    }
}