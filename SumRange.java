import java.util.Scanner;

public class SumRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter starting number: ");
        int start = sc.nextInt();

        System.out.print("Enter ending number: ");
        int end = sc.nextInt();

        int sum = 0;

        while (start <= end) {
            sum += start;
            start++;
        }

        System.out.println("Sum = " + sum);
    }
}
