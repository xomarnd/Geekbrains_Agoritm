package Lesson_5;

import java.util.Arrays;
import java.util.List;

//3. В парсер выражений из файла RecursiveDescentParser.java добавть возможность вычисления функция sin(n), cos(n), tg(n), ctg(n), ln(n).

/**
 * TrigFun -> Term
 * Expr -> Term + Expr | Term - Expr | Term
 * Term -> Factor * Term | Factor / Term | Factor
 * Factor -> Number | (Expr) | func(Expr)
 *
 * 2 + 2 - 3
 * 2 + 3 * ( 4 + 5 ) - 6 * 7 + sin(10) + cos(12 + 1)
 *
 */
public class RecursiveDescentParser {

    private final List<String> tokens;
    private int pos = 0;

    public RecursiveDescentParser(List<String> tokens) {
        this.tokens = tokens;
    }

    public Double parse() {
        return expression();
    }

     //Expr -> Term + Expr | Term - Expr | Term
    private Double expression() {
        Double first = term();

        while (pos < tokens.size()) {
            String operator = tokens.get(pos);

            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            Double second = term();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    //Term -> Factor * Term | Factor / Term | Factor
    private Double term() {
        Double first = factor();

        while (pos < tokens.size()) {
            String operator = tokens.get(pos);
            if (!operator.equals("*") && !operator.equals("/")) {
                return first;
            } else {
                pos++;
            }

            Double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }



    //Factor -> Number | (Expr) | func(Expr)
    private Double factor() {
        String next = tokens.get(pos);
        Double result = null;
        if (next.equals("(")) {
            pos++;
            result = expression();
            String closingBracket = null;
            if (pos < tokens.size() && (closingBracket = tokens.get(pos)).equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }else if (next.equals("sin(") || next.equals("cos(") || next.equals("tg(") || next.equals("ctg(")
                || next.equals("ln("))
        {
            if (next.equals("sin(")) {
                pos++;
                result = Math.sin(expression());
            } else if (next.equals("cos(")) {
                pos++;
                result = Math.cos(expression());
            } else if (next.equals("tg(")) {
                pos++;
                result = Math.tan(expression());
            } else if (next.equals("ctg(")) {
                pos++;
                result = 1.0 / Math.tan(expression());
            } else if (next.equals("ln(")) {
                pos++;
                result = Math.log(expression());
            } else {
                System.err.println("function '" + next + "' is not defined");
            }
            String closingBracket = null;
            if (pos < tokens.size() && (closingBracket = tokens.get(pos)).equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }
        pos++;
        return Double.parseDouble(next);
    }

    public static void main(String[] args) {
        String expr = "2.111 * 3.5 + ( 3 + 4 * ( 2.1 + 3 ) - 10 ) * ( 5 - 7 + 4 - 2 ) + 11 + sin( 10 ) + cos( 12 + 1 ) + ln( 20 ) * ctg( 80 )";
        RecursiveDescentParser recursiveDescentParser = new RecursiveDescentParser(Arrays.asList(expr.split(" ")));
        System.out.println(recursiveDescentParser.parse());
        System.out.println(2.111*3.5+(3 + 4 * (2.1 + 3) - 10 )*(5-7+4-2) + 11);
    }
}
