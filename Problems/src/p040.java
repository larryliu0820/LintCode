import java.util.Stack;

/**
 * Created by Valued Customer on 4/1/2017.
 * Implement Queue by Two Stacks
 *
 * As the title described, you should only use two stacks to implement a queue's actions.

 The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

 Both pop and top methods should return the value of first element.

 Example
 push(1)
 pop()     // return 1
 push(2)
 push(3)
 top()     // return 2
 pop()     // return 2
 *
 */

public class p040 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public p040() {
        // do initialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if (stack2.isEmpty())  {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}
