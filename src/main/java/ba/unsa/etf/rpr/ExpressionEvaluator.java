package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator {
    public Double evaluate(String string) {
        Stack<String> operands = new Stack<String>();
        Stack<Double> values = new Stack<Double>();
        string = string.trim(); //remove spaces from both sides
        if (!string.startsWith("("))
            throw new RuntimeException("Pogreska pri unosu");

        for (int i = 0; i < string.length(); i++) {

            //multi-spacing check
            if (string.charAt(i) == ' ' && i<string.length()-1 && string.charAt(i + 1) == ' ')
                throw new RuntimeException("Pogreska pri unosu");

            //substring setting
            String substring = "";
            while (string.charAt(i) != ' ') {
                substring = substring + string.charAt(i);
                if (i++ == string.length() - 1) break;
            }

            //substring validation
            if ( substring.equals("+") || substring.equals("-")
              || substring.equals("/") || substring.equals("*")
              || substring.equals("(") || substring.equals(")")
              || substring.equals("sqrt")) ;
            else {
                Double.parseDouble(substring);
                // this will throw an exception if substring is not a valid number
            }

            //Dijkstra’s Algorithm if string is valid
                if (substring.equals("(")) ;
                else if (substring.equals("+")) operands.push(substring);
                else if (substring.equals("-")) operands.push(substring);
                else if (substring.equals("*")) operands.push(substring);
                else if (substring.equals("/")) operands.push(substring);
                else if (substring.equals("sqrt")) operands.push(substring);
                else if (substring.equals(")")) {
                    String op = operands.pop();
                    double v = values.pop();
                    if (op.equals("+")) v = values.pop() + v;
                    else if (op.equals("-")) v = values.pop() - v;
                    else if (op.equals("*")) v = values.pop() * v;
                    else if (op.equals("/")) v = values.pop() / v;
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    values.push(v);
                } else values.push(Double.parseDouble(substring));
        }
        if(!operands.isEmpty()) throw new RuntimeException("Pogreska pri unosu");
        return values.pop();
    }
}
