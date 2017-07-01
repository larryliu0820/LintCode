import java.util.List;

/**
 * Created by Valued Customer on 6/25/2017.
 */
public class NInteger implements NestedInteger {
    int value;
    List<NestedInteger> list;
    boolean isInteger;

    public NInteger() {}
    public NInteger(int v) {
        this.value = v;
        this.isInteger = true;
    }

    public NInteger(List<NestedInteger> list) {
        this.list = list;
        this.isInteger = false;
    }

    public Integer getInteger() {
        return this.value;
    }

    public List<NestedInteger> getList() {
        return this.list;
    }

    public boolean isInteger() {
        return isInteger;
    }
}
