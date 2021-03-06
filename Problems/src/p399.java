import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Valued Customer on 3/3/2017.
 * Nuts & Bolts Problem
 * Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and
 * bolts. Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared
 * with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

 We will give you a compare function to compare nut with bolt.

 Have you met this question in a real interview? Yes
 Example
 Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

 Your code should find the matching bolts and nuts.

 one of the possible return:

 nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

 we will tell you the match compare function. If we give you another compare function.

 the possible return is the following:

 nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

 So you must use the compare function that we give to do the sorting.

 The order of the nuts or bolts does not matter. You just need to find the matching bolt for each nut.
 */
public class p399 {
    /**
     * public class NBComparator {
     *     public int cmp(String a, String b);
     * }
     * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
     * if "a" is bigger than "b", it will return 1, else if they are equal,
     * it will return 0, else if "a" is smaller than "b", it will return -1.
     * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
     */

    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here

        sortHelper(nuts, bolts, 0, nuts.length-1, compare);
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

    private void sortHelper(String[] nuts, String[] bolts, int low, int high, NBComparator compare) {
        if (low < high) {
            int pivot = partition(nuts, low, high, bolts[high], compare);
            partition(bolts, low, high, nuts[pivot], compare);

            sortHelper(bolts, nuts, low, pivot - 1, compare);
            sortHelper(bolts, nuts, pivot + 1, high, compare);
        }
    }
    private int partition(String[] arr, int low, int high, String pivot, NBComparator compare) {
        int i = low, j = high;
        int test = compare.cmp(arr[i], pivot);
        if (test != 2) {
            while (i < j) {
                while (compare.cmp(arr[i], pivot) < 0) i++;
                while (compare.cmp(arr[j], pivot) > 0) j--;
                swap(arr, i, j);
            }
        } else {
            while (i < j) {
                while (compare.cmp(pivot, arr[i]) > 0) i++;
                while (compare.cmp(pivot, arr[j]) < 0) j--;

                swap(arr, i, j);
            }
        }
        return i;
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        String[] nuts = new String[]{"ab","bc","dd","gg"};
        String[] bolts = new String[]{"AB","GG","DD","BC"};
        p399 sol = new p399();
        sol.sortNutsAndBolts(nuts, bolts, new NBComparator());
    }
}
