//import java.util.Arrays;

public class PostfixEvaluator {
    public static int evaluatePostfix(String expression) {
        String[] tokens = expression.split(" ");
        int[] stack = new int[tokens.length];
        int top = -1;
        
        for (String token : tokens) {
            if (isNumeric(token)) {
                int value = Integer.parseInt(token);
                stack[++top] = value;
            } else {
                int operand2 = stack[top--];
                int operand1 = stack[top--];
                int result = performOperation(operand1, operand2, token);
                stack[++top] = result;
            }
        }
        
        return stack[0];
    }
    
    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
    public static void main(String[] args) {
        String postfixExpression = "5 3 2 * +";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}
