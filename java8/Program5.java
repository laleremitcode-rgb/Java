public class Program5 {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            try {
                int result = 10 / 0; 
            } catch (ArithmeticException e) {
                System.out.println("Inner Catch: Cannot divide by zero.");
            }
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer Catch: Array index out of bounds.");
        }
    }
}