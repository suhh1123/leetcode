package Stack;

import java.util.Stack;

public class BasicCalculatrIII {
    public static class operatorLevel {
        char operator;
        int level;
        public operatorLevel(char operator, int level) {
            this.operator = operator;
            this.level = level;
        }
    }

    public int calculate(String s) {
        Stack<operatorLevel> operatorStack = new Stack<>();
        Stack<Integer> operandStack = new Stack<>();

        int paranthesisLevel = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                int res = (int) s.charAt(i) - '0';
                while (i + 1 < s.length() && '0' <= s.charAt(i + 1) && s.charAt(i + 1) <= '9') {
                    i ++;
                    res = res * 10 + (int) s.charAt(i) - '0';
                }
                operandStack.push(res);
            } else if (s.charAt(i) == '(') {
                paranthesisLevel += 10;
            } else if (s.charAt(i) == ')') {
                paranthesisLevel -= 10;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                int level = 0;
                if (s.charAt(i) == '+' || s.charAt(i) == '-') level = 0;
                else if (s.charAt(i) == '*' || s.charAt(i) == '/') level = 1;

                while (!operatorStack.isEmpty() && operatorStack.peek().level >= level + paranthesisLevel) {
                    evaluateTopOperator(operatorStack, operandStack);
                }
                operatorStack.push(new operatorLevel(s.charAt(i), level + paranthesisLevel));
            }
        }
        while (!operatorStack.isEmpty()) {
            evaluateTopOperator(operatorStack, operandStack);
        }
        return operandStack.pop();
    }

    private void evaluateTopOperator(Stack<operatorLevel> operatorStack, Stack<Integer> operandStack) {
        operatorLevel operatorlevel = operatorStack.pop();
        int b = operandStack.pop();
        int a = operandStack.pop();
        if (operatorlevel.operator == '+') {
            operandStack.push(a + b);
        } else if (operatorlevel.operator == '-') {
            operandStack.push(a - b);
        } else if (operatorlevel.operator == '*') {
            operandStack.push(a * b);
        } else if (operatorlevel.operator == '/') {
            operandStack.push(a / b);
        }
    }

    public static void main(String[] args) {
        BasicCalculatrIII b = new BasicCalculatrIII();
        String s = "2*(5+5*2)/3+(6/2+8)";
        int res = b.calculate(s);
        System.out.print(res);
    }
}
