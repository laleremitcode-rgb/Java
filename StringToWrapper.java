import java.util.Scanner;
public class StringToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String str = sc.nextLine();
        Integer obj = Integer.valueOf(str);
        int num = obj.intValue();
        System.out.println("Original String: " + str);
        System.out.println("Wrapper Object: " + obj);
        System.out.println("Primitive Value: " + num);
    }
}