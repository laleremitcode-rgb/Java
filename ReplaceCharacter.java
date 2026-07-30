public class ReplaceCharacter {
    public static void main(String[] args) {
        String str = "hello";
        int index = 1;
        char ch = 'a';
        char[] arr = str.toCharArray();
        arr[index] = ch;
        String result = new String(arr);
        System.out.println("Original String: " + str);
        System.out.println("Modified String: " + result);
    }
}
