public class Program2 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int index = 5; 
        try {
            System.out.println("Element: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index " + index + " is invalid for the array.");
        } finally {
            System.out.println("Access attempt completed");
        }
    }
}