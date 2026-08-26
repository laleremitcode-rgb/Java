public class Program4 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};
        int divisor = 0;
        int index = 1;
        try {
            int value = numbers[index]; 
            int result = value / divisor; 
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds.");
        }
    }
}