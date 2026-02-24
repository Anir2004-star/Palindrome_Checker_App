import java.util.*;

public class PalindromeChecker {

    // 🔹 Approach 1: Reverse String Method
    public static boolean reverseMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(normalized).reverse().toString();
        return normalized.equals(reversed);
    }

    // 🔹 Approach 2: Stack Method
    public static boolean stackMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // 🔹 Approach 3: Two Pointer Method
    public static boolean twoPointerMethod(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC13 - Performance Comparison) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // 🔹 Reverse Method Timing
        long start1 = System.nanoTime();
        boolean result1 = reverseMethod(input);
        long end1 = System.nanoTime();
        long time1 = end1 - start1;

        // 🔹 Stack Method Timing
        long start2 = System.nanoTime();
        boolean result2 = stackMethod(input);
        long end2 = System.nanoTime();
        long time2 = end2 - start2;

        // 🔹 Two Pointer Method Timing
        long start3 = System.nanoTime();
        boolean result3 = twoPointerMethod(input);
        long end3 = System.nanoTime();
        long time3 = end3 - start3;

        System.out.println("\n--- Results ---");
        System.out.println("Reverse Method: " + (result1 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + time1 + " ns");

        System.out.println("Stack Method: " + (result2 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + time2 + " ns");

        System.out.println("Two Pointer Method: " + (result3 ? "Palindrome" : "Not Palindrome")
                + " | Time: " + time3 + " ns");

        scanner.close();
    }
}

