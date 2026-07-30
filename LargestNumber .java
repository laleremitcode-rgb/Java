import java.util.Scanner;
public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second number: ");
        String s2 = sc.nextLine();
        System.out.print("Enter third number: ");
        String s3 = sc.nextLine();
        Integer n1 = Integer.valueOf(s1);
        Integer n2 = Integer.valueOf(s2);
        Integer n3 = Integer.valueOf(s3);
        if (n1 >= n2 && n1 >= n3)
            System.out.println("Largest = " + n1);
        else if (n2 >= n1 && n2 >= n3)
            System.out.println("Largest = " + n2);
        else
            System.out.println("Largest = " + n3);
    }
}