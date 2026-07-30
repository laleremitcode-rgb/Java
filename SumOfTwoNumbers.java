import java.util.Scanner;
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second number: ");
        String s2 = sc.nextLine();
        Integer n1 = Integer.valueOf(s1);
        Integer n2 = Integer.valueOf(s2);
        System.out.println("Sum = " + (n1 + n2));
    }
}