import java.util.Stack;

/**
 * Created by Valued Customer on 4/1/2017.
 *
 * Min Stack
 *
 * Implement a stack with min() function, which will return the smallest number in the stack.

 It should support push, pop and min operation all in O(1) cost.

 Notice

 min operation will never be called if there is no number in the stack.

 Example
 push(1)
 pop()   // return 1
 push(2)
 push(3)
 min()   // return 2
 push(1)
 min()   // return 1
 */
public class p012 {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public p012() {
        // do initialize if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        if (stack.isEmpty()) {
            minStack.push(number);
        } else {
            int min = min();
            if (number < min) minStack.push(number);
            else minStack.push(min);
        }
        stack.push(number);
    }

    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
