public class InfixToPrefixPostfix {
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int getPrecedence(char c) {
        if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }

    private static String convertToPrefix(String infix) {
        int length = infix.length();
        char[] prefixArray = new char[length];
        char[] stack = new char[length];
        int top = -1;
        int prefixIndex = 0;

        for (int i = length - 1; i >= 0; i--) {
            char currentChar = infix.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                prefixArray[prefixIndex++] = currentChar;
            } else if (currentChar == ')') {
                stack[++top] = currentChar;
            } else if (currentChar == '(') {
                while (top != -1 && stack[top] != ')') {
                    prefixArray[prefixIndex++] = stack[top--];
                }

                if (top != -1)
                    top--; // Discard the closing bracket
            } else if (isOperator(currentChar)) {
                while (top != -1 && getPrecedence(stack[top]) >= getPrecedence(currentChar)) {
                    prefixArray[prefixIndex++] = stack[top--];
                }
                stack[++top] = currentChar;
            }
        }

        while (top != -1) {
            prefixArray[prefixIndex++] = stack[top--];
        }

        return new String(prefixArray, 0, prefixIndex);
    }

    private static String convertToPostfix(String infix) {
        int length = infix.length();
        char[] postfixArray = new char[length];
        char[] stack = new char[length];
        int top = -1;
        int postfixIndex = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = infix.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                postfixArray[postfixIndex++] = currentChar;
            } else if (currentChar == '(') {
                stack[++top] = currentChar;
            } else if (currentChar == ')') {
                while (top != -1 && stack[top] != '(') {
                    postfixArray[postfixIndex++] = stack[top--];
                }

                if (top != -1)
                    top--; // Discard the opening bracket
            } else if (isOperator(currentChar)) {
                while (top != -1 && getPrecedence(stack[top]) >= getPrecedence(currentChar)) {
                    postfixArray[postfixIndex++] = stack[top--];
                }
                stack[++top] = currentChar;
            }
        }

        while (top != -1) {
            postfixArray[postfixIndex++] = stack[top--];
        }

        return new String(postfixArray, 0, postfixIndex);
    }

    public static void main(String[] args) {
        String infixExpression = "A+(B*C)";
        String prefixExpression = convertToPrefix(infixExpression);
        String postfixExpression = convertToPostfix(infixExpression);

        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}
