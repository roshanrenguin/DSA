import java.util.Scanner;
public class InfixToPostfixEvaluator {
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        int length = infix.length();
        int top = -1;
        char[] stack = new char[length];

        for (int i = 0; i < length; i++) {
            char currentChar = infix.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                postfix.append(currentChar);
            } else if (currentChar == '(') {
                stack[++top] = currentChar;
            } else if (currentChar == ')') {
                while (top >= 0 && stack[top] != '(') {
                    postfix.append(stack[top--]);
                }
                top--; // Discard the '('
            } else if (isOperator(currentChar)) {
                while (top >= 0 && precedence(stack[top]) >= precedence(currentChar)) {
                    postfix.append(stack[top--]);
                }
                stack[++top] = currentChar;
            }
        }

        while (top >= 0) {
            postfix.append(stack[top--]);
        }

        return postfix.toString();
    }

    private static int evaluatePostfix(String postfix) {
        int length = postfix.length();
        int top = -1;
        int[] stack = new int[length];

        for (int i = 0; i < length; i++) {
            char currentChar = postfix.charAt(i);

            if (Character.isDigit(currentChar)) {
                stack[++top] = currentChar - '0';
            } else if (isOperator(currentChar)) {
                int operand2 = stack[top--];
                int operand1 = stack[top--];
                int result = performOperation(operand1, operand2, currentChar);
                stack[++top] = result;
            }
        }

        return stack[0];
    }

    private static int performOperation(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        //String infixExpression = "3+(4*2)-6/(1+2)";
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the infix expression you want to convert: ");
    	String infixExpression = sc.next();
    	String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}
