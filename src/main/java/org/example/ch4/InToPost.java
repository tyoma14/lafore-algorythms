package org.example.ch4;

/**
 * Created by Artyom Zheltyshev on 19.06.2024
 * Преобразователь арифметических выражений
 * из инфиксной формы в постфиксную
 */
public class InToPost {

    private StackX<Character> theStack;
    private String input;
    private String output = "";

    public InToPost(String input) {
        this.input = input;
        this.theStack = new StackX<>(input.length());
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output += ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output += theStack.pop();
        }
        theStack.displayStack("End ");
        return output;
    }

    public void gotOperator(char opThis, int prec1) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop=='+' || opTop=='-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    theStack.push(opTop);
                    break;
                } else {
                    output += opTop;
                }
            }
        }
        theStack.push(opThis);
    }

    public void gotParen(char ch) {
        while (!theStack.isEmpty()) {
            Character chx = theStack.pop();
            if (chx == '(') {
                break;
            } else {
                output += chx;
            }
        }
    }

}
