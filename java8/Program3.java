public class Program3 {
    public static void convertToNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + input + "' is not a valid integer.");
        }
    }
    public static void main(String[] args) {
        convertToNumber("123");
        convertToNumber("abc");
    }
}