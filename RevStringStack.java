public class RevStringStack  {
    private static class Stack {
        private char[] array;
        private int top;

        public Stack(int capacity) {
            array = new char[capacity];
            top = -1;
        }

        public void push(char item) {
            array[++top] = item;
        }

        public char pop() {
            return array[top--];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static String reverseString(String input) {
        // Create a stack of characters
        Stack stack = new Stack(input.length());

        // Iterate through each character in the input string and push them onto the stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Create an empty string to store the reversed string
        StringBuilder reversedString = new StringBuilder();

        // Pop each character from the stack and append it to the reversed string
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        // Return the reversed string
        return reversedString.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverseString(input);
        System.out.println(reversed);
    }
}
