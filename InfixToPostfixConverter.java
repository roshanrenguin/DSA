
class InfixToPostfixConverter {
	
	public static class Stack {
	    private char[] stackArray;
	    private int top;
	    private int maxSize;

	    public Stack(int size) {
	        maxSize = size;
	        stackArray = new char[maxSize];
	        top = -1;
	    }

	    public void push(char c) {
	        stackArray[++top] = c;
	    }

	    public char pop() {
	        return stackArray[top--];
	    }

	    public char peek() {
	        return stackArray[top];
	    }

	    public boolean isEmpty() {
	        return (top == -1);
	    }
	}

    private Stack stack;
    private String infixExpression;
    private String postfixExpression;

    public InfixToPostfixConverter(String infix) {
        stack = new Stack(infix.length());
        infixExpression = infix;
        postfixExpression = "";
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    public String convertToPostfix() {
        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                postfixExpression += currentChar + " ";
            } else if (isOperator(currentChar)) {
                while (!stack.isEmpty() && precedence(currentChar) <= precedence(stack.peek())) {
                    postfixExpression += stack.pop() + " ";
                }
                stack.push(currentChar);
            } else if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression += (stack.pop()) + " ";
                }
                stack.pop(); // Discard the '('
            }
        }

        while (!stack.isEmpty()) {
            postfixExpression += stack.pop() + " ";
        }

        return postfixExpression;
    }
    
    public static void main(String[] args) {
        //String infixExpression = "A + B * C - D / E";
    	String infixExpression = "2 + 3 * 4 - ( 5 + 6 )";
        InfixToPostfixConverter converter = new InfixToPostfixConverter(infixExpression);
        String postfixExpression = converter.convertToPostfix();
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}




