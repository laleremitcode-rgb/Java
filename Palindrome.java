import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        int i = 0;
        int j = str.length() - 1;
        int flag = 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                flag = 0;
                break;
            }
            i++;
            j--;
        }
        if (flag == 1)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
