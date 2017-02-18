import java.util.*;

/**
 * Created by Valued Customer on 1/17/2017.
 */
public class HashHeap {
    ArrayList<Integer> heap;
    String mode;
    int size_t;
    Map<Integer, Set<Integer>> hash;

    public HashHeap(String mod) { // 传入min 表示最小堆，max 表示最大堆
        // TODO Auto-generated constructor stub
        heap = new ArrayList<>();
        mode = mod;
        hash = new HashMap<>();
        size_t = 0;
    }

    int peek() {
        return heap.get(0);
    }

    int size() {
        return size_t;
    }

    Boolean empty() {
        return (heap.size() == 0);
    }

    int parent(int id) {
        if (id == 0) {
            return -1;
        }
        return (id - 1) / 2;
    }

    int lson(int id) {
        return id * 2 + 1;
    }

    int rson(int id) {
        return id * 2 + 2;
    }

    boolean comparesmall(int a, int b) {
        if (a <= b) {
            return mode.equals("min");
        } else {
            return mode.equals("max");
        }

    }

    void swap(int idA, int idB) {
        int valA = heap.get(idA);
        int valB = heap.get(idB);
        if (valA == valB) return;
        heap.set(idA, valB);
        heap.set(idB, valA);

        Set<Integer> setA = new HashSet<>(hash.get(valA));
        Set<Integer> setB = new HashSet<>(hash.get(valB));

        setA.remove(idA);
        setA.add(idB);
        setB.remove(idB);
        setB.add(idA);

        hash.put(valA, setA);
        hash.put(valB, setB);
    }

    Integer poll() {
        size_t--;
        Integer now = heap.get(0);
        int bottom = heap.size() - 1;
        swap(0, bottom);
        Set<Integer> hashnow = hash.get(now);
        heap.remove(bottom);
        if (hashnow.size() == 1) {
            hash.remove(now);
        } else {
            hashnow.remove(bottom);
            hash.put(now, new HashSet<>(hashnow));
        }
        if (heap.size() > 0) {
            siftdown(0);
        }

        return now;
    }

    void add(int now) {
        size_t++;
        heap.add(now);
        int bottom = heap.size() - 1;
        if (hash.containsKey(now)) {
            Set<Integer> hashnow = hash.get(now);
            hashnow.add(bottom);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(bottom);
            hash.put(now, set);
        }
        siftup(bottom);
    }

    void delete(int now) {
        size_t--;
        Set<Integer> hashnow = hash.get(now);
        Iterator<Integer> it = hashnow.iterator();
        int id = it.next();
        int bottom = heap.size() - 1;
        swap(id, bottom);
        heap.remove(bottom);
        hashnow = hash.get(now);
        if (hashnow.size() == 1) {
            hash.remove(now);
        } else {
            hashnow.remove(bottom);
            hash.put(now, new HashSet<>(hashnow));
        }

        if (heap.size() > id) {
            siftup(id);
            siftdown(id);
        }
    }

    void siftup(int id) {
        while (parent(id) > -1) {
            int parentId = parent(id);
            if (comparesmall(heap.get(parentId), heap.get(id))) {
                break;
            } else {
                swap(id, parentId);
            }
            id = parentId;
        }
    }

    void siftdown(int id) {
        while (lson(id) < heap.size()) {
            int leftId = lson(id);
            int rightId = rson(id);
            int son;
            if (rightId >= heap.size() || (comparesmall(heap.get(leftId), heap.get(rightId)))) {
                son = leftId;
            } else {
                son = rightId;
            }
            if (comparesmall(heap.get(id), heap.get(son))) {
                break;
            } else {
                swap(id, son);
            }
            id = son;
        }
    }
}
