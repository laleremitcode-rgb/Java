import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        String r = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            r = r + str.charAt(i);
        }
        System.out.println("Reverse = " + r);
    }
}
