/**
 * Created by Valued Customer on 3/3/2017.
 */
public class NBComparator {

    public int cmp(String a, String b) {
        int maxLen = a.length() > b.length()?a.length():b.length();
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() < maxLen) {
            for (int i = 0; i < maxLen - a.length(); i++) a = "0" + a;
        }
        if (b.length() < maxLen) {
            for (int i = 0; i < maxLen - b.length(); i++) b = "0" + b;
        }
        for (int i = 0; i < maxLen; i++) {
            if (a.charAt(i) > b.charAt(i)) return 1;
            else if (a.charAt(i) < b.charAt(i)) return -1;
        }
        return 0;
    }

}
