import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collector;

/**
 * Created by Valued Customer on 3/21/2017.
 *
 * Expression Expand
 *
 * Given an expression s includes numbers, letters and brackets. Number represents the number of repetitions inside the
 * brackets(can be a string or another expression)．Please expand expression to be a string.
 *
 * Example
 s = abc3[a] return abcaaa
 s = 3[abc] return abcabcabc
 s = 4[ac]dy, return acacacacdy
 s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz

 */


public class p575 {
    private String popStack(Stack<Object> stack) {
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) sb.append(buffer.pop());
        return sb.toString();
    }
    public String expressionExpand(String s) {
        // stack version
        Stack<Object> stack = new Stack<>();
        int multiplier = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multiplier = multiplier * 10 + c - '0';
            } else if (c == '[') {
                stack.push(multiplier);
                multiplier = 0;
            } else if (c == ']') {
                String newStr = popStack(stack);
                Integer count = (Integer) stack.pop();
                for (int i = 0; i < count; i++) stack.push(newStr);
            } else {
                stack.push(String.valueOf(c));
            }
        }
        return popStack(stack);
    }
}
