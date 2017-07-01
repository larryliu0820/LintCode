import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Valued Customer on 6/24/2017.
 * Flatten Nested List Iterator
 *
 * Given a nested list of integers, implement an iterator to flatten it.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Notice

 You don't need to implement the remove method.

 Example
 Given the list [[1,1],2,[1,1]], By calling next repeatedly until hasNext returns false, the order of elements returned
 by next should be: [1,1,2,1,1].

 Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns false, the order of elements returned by
 next should be: [1,4,6].
 */
public class p528 implements Iterator<Integer>{
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer,
     *     // rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds,
     *     // if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds,
     *     // if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    List<NestedInteger> nestedList;
    int index = -1;
    NestedInteger currInt;
    p528 childIterator;
    public p528(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        this.nestedList = nestedList;
        getNextInt();
    }

    private void getNextInt() {
        index++;
        if (index < nestedList.size())  {
            currInt = nestedList.get(index);
            if (!currInt.isInteger()) childIterator = new p528(currInt.getList());
        }
    }
    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if (currInt.isInteger()) {
            int result = currInt.getInteger();
            getNextInt();
            return result;
        } else {
            if (!childIterator.hasNext()) {
                getNextInt();
                return next();
            } else {
                return childIterator.next();
            }
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (
                index < nestedList.size() &&
                !currInt.isInteger() &&
                (currInt.getList() == null || currInt.getList().size() == 0)
                )
            getNextInt();
        if (index == nestedList.size()-1) {
            return currInt.isInteger() || childIterator.hasNext();
        } else if (index > nestedList.size()-1) {
            return false;
        } else return true;
    }

    @Override
    public void remove() {}

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>(3);
        NInteger i = new NInteger();
        i.list = new ArrayList<>();
//        i.list.add(new NInteger(1));
//        i.list.add(new NInteger(1));
        list.add(i);
//        list.add(new NInteger(2));
        NInteger j = new NInteger();
        j.list = new ArrayList<>();
//        j.list.add(new NInteger(1));
//        j.list.add(new NInteger(1));
        list.add(j);
        p528 sol = new p528(list);
        while (sol.hasNext()) System.out.println(sol.next());

    }
}
