import java.util.Scanner;

public class CheckPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String setPassword = "admin123";

        System.out.print("Enter Password: ");
        String userPassword = sc.nextLine();

        if (userPassword.equals(setPassword)) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Incorrect password.");
        }
    }
}
