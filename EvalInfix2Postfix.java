import java.util.Scanner;
public class EvalInfix2Postfix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the infix expression you want to convert: ");
		//reads a infix expression from the user
		String infixExpression = sc.next();
		sc.close();
		
		
		System.out.println("Infix Expression: " + infixExpression);
		String postfixExpression = convertToPostfix(infixExpression);
		System.out.println("Postfix Expression: " + postfixExpression);
		
		int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);

	}
	public static String convertToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        StringBuilder stack = new StringBuilder();
        
        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);
            
            if (ch == ' ') {
                continue;
            } else if (Character.isDigit(ch)) {
                postfix.append(ch);
                
                // Append any subsequent digits to the current operand
                while (i + 1 < infixExpression.length() && Character.isDigit(infixExpression.charAt(i + 1))) {
                    i++;
                    postfix.append(infixExpression.charAt(i));
                }
            } else if (ch == '(') {
                stack.append(ch);
            } else if (ch == ')') {
                while (stack.charAt(stack.length() - 1) != '(') {
                    postfix.append(stack.charAt(stack.length() - 1));
                    stack.deleteCharAt(stack.length() - 1);
                }
                stack.deleteCharAt(stack.length() - 1); // Remove '(' from stack
            } else {
                while (stack.length() > 0 && getPrecedence(ch) <= getPrecedence(stack.charAt(stack.length() - 1))) {
                    postfix.append(stack.charAt(stack.length() - 1));
                    stack.deleteCharAt(stack.length() - 1);
                }
                stack.append(ch);
            }
        }
        
        // Append any remaining operators from the stack to the postfix expression
        while (stack.length() > 0) {
            postfix.append(stack.charAt(stack.length() - 1));
            stack.deleteCharAt(stack.length() - 1);
        }
        
        return postfix.toString();
    }
    
    public static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    
    public static int evaluatePostfix(String postfixExpression) {
    	String[] tokens = new String[postfixExpression.length()];
        for (int i = 0; i < postfixExpression.length(); i++) {
            tokens[i] = String.valueOf(postfixExpression.charAt(i));
        }
        int[] stack = new int[tokens.length];
        int top = -1;
        
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack[++top] = Integer.parseInt(token);
            } else {
                int operand2 = stack[top--];
                int operand1 = stack[top--];
                int result = performOperation(token, operand1, operand2);
                stack[++top] = result;
            }
        }
        
        return stack[top];
    }
    
    public static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static int performOperation(String operator, int operand1, int operand2) {
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

}

