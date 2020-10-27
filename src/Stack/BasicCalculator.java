package Stack;

import java.util.Stack;

public class BasicCalculator {
    public static class OperatorLevel {
        char operator;
        int level;
        public OperatorLevel(char operator, int level) {
            this.operator = operator;
            this.level = level;
        }
    }

    public int calculate(String expression) {
        Stack<OperatorLevel> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();

        int parenthesisLevel = 0;
        for (int i = 0; i < expression.length(); i++) {
            if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') {
                int res = (int) expression.charAt(i) - '0';
                while (i + 1 < expression.length() && '0' <= expression.charAt(i + 1) && expression.charAt(i + 1) <= '9') {
                    i ++;
                    res = res * 10 + (int) expression.charAt(i) - '0';
                }
                operandStack.push(res);
            } else if (expression.charAt(i) == '(') {
                parenthesisLevel ++;
            } else if (expression.charAt(i) == ')') {
                parenthesisLevel --;
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                while (!operatorStack.isEmpty() && operatorStack.peek().level >= parenthesisLevel) {
                    evaluateTopOperator(operatorStack, operandStack);
                }
                operatorStack.push(new OperatorLevel(expression.charAt(i), parenthesisLevel));
            }
        }
        while (!operatorStack.isEmpty()) {
            evaluateTopOperator(operatorStack, operandStack);
        }
        return operandStack.pop();
    }

    private void evaluateTopOperator(Stack<OperatorLevel> operatorStack, Stack<Integer> operandStack) {
        OperatorLevel operatorLevel = operatorStack.pop();
        int b = operandStack.pop(), a = operandStack.pop();
        if (operatorLevel.operator == '+') {
            operandStack.push(a + b);
        } else if (operatorLevel.operator == '-') {
            operandStack.push(a - b);
        }
    }

    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        String expression = "10-(40-5)+100";
        int res = b.calculate(expression);
        System.out.print(res);
    }
}
