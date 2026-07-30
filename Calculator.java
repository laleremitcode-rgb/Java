import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second number: ");
        String s2 = sc.nextLine();
        Integer n1 = Integer.valueOf(s1);
        Integer n2 = Integer.valueOf(s2);
        System.out.print("Enter operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        switch (op) {
            case '+':
                System.out.println("Result = " + (n1 + n2));
                break;
            case '-':
                System.out.println("Result = " + (n1 - n2));
                break;
            case '*':
                System.out.println("Result = " + (n1 * n2));
                break;
            case '/':
                if (n2 != 0)
                    System.out.println("Result = " + (n1 / n2));
                else
                    System.out.println("Division by zero is not allowed.");
                break;
            default:
                System.out.println("Invalid Operation");
        }
    }
}