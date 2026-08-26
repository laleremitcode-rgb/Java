import java.util.Scanner;
import java.util.Random;
import java.lang.Math;
public class BuiltInPackageDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter a maximum limit for random numbers: ");
        int limit = scanner.nextInt();
        int num1 = random.nextInt(limit) + 1;
        int num2 = random.nextInt(limit) + 1;
        System.out.println("First Random Number: " + num1);
        System.out.println("Second Random Number: " + num2);
        int maxNumber = Math.max(num1, num2);
        double squareRoot = Math.sqrt(num1);
        double powerResult = Math.pow(num1, 2);
        System.out.println("Larger of the two numbers: " + maxNumber);
        System.out.println("Square root of " + num1 + ": " + squareRoot);
        System.out.println("Square of " + num1 + ": " + powerResult);
        scanner.close();
    }
}