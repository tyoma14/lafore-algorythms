package org.example.ch4;

/**
 * Created by Artyom Zheltyshev on 19.06.2024
 * Вычисление арифметического выражения в постфиксной форме
 */
public class CalcPost {

    private StackX<Integer> theStack;
    private String input;

    public CalcPost(String input) {
        this.input = input;
    }

    public int doCalc() {
        theStack = new StackX<>((input.length() + 1) / 2);
        char ch;
        int j;
        int num1;
        int num2;
        int interAns;

        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            theStack.displayStack(ch + " ");
            if (ch >= '0' && ch <= '9') {
                theStack.push((ch - '0'));
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}
