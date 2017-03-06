import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Valued Customer on 2/20/2017.
 * Building Outline
 *
 * Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，
 * where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building.
 * Buildings may overlap if you see them from far away，find the outline of them。

 An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline,
 end is the end position on x-axis and height is the height of the outline.

 Notice

 Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.

 Example
 Given 3 buildings：

 [
 [1, 3, 3],
 [2, 4, 4],
 [5, 6, 1]
 ]
 The outlines are：

 [
 [1, 2, 3],
 [2, 4, 4],
 [5, 6, 1]
 ]

 */
public class p131 {

    public class Turple implements Comparable<Turple>{
        int time;
        int height;
        boolean isUp;
        public int compareTo(Turple turple) {
            if (time != turple.time)
                return time - turple.time;
            else {
                if (isUp == turple.isUp) return 0;
                return isUp ? -1 : 1;
            }
        }
        public Turple(int t, int h, boolean u) {
            time = t;
            height = h;
            isUp = u;
        }
    }
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        List<Turple> turpleList = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            turpleList.add(new Turple(building[0], building[2], true));
            turpleList.add(new Turple(building[1], building[2], false));
        }
        Collections.sort(turpleList);

        FastHashHeap heightPq = new FastHashHeap("max");
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int startTime = 0;
        for (int i = 0; i < turpleList.size(); i++) {
            Turple currTurple = turpleList.get(i);
            int currHeight = heightPq.size() == 0?0:heightPq.peek();
            if (currTurple.isUp) {
                heightPq.add(currTurple.height);
                if (startTime == currTurple.time) continue;
                if (heightPq.peek() != currHeight) {
                    if (currHeight != 0) {
                        ArrayList<Integer> outline = new ArrayList<>(Arrays.asList(startTime, currTurple.time, currHeight));
                        result.add(outline);
                    }
                    startTime = currTurple.time;
                }
            } else {
                heightPq.delete(currTurple.height);
                if (startTime == currTurple.time) continue;
                if (heightPq.size() == 0 || heightPq.peek() != currHeight) {
                    ArrayList<Integer> outline = new ArrayList<>(Arrays.asList(startTime, currTurple.time, currHeight));
                    result.add(outline);
                    startTime = currTurple.time;
                }
            }

        }
        return result;
    }
    public static void main(String[] args) {
        p131 sol = new p131();
        String filename = "Problems/src/12.in";
        int[][] data = null;
        try {
            FileReader fileReader = new FileReader(filename);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String content = bufferedReader.readLine();
            String[] list = content.split("]");

            data = new int[list.length][];
            for (int i = 0; i < list.length; i++) {
                String nums = list[i].substring(2);
                String[] numList = nums.split(",");
                data[i] = new int[3];
                for (int j = 0; j < 3; j++) data[i][j] = Integer.parseInt(numList[j]);
                System.out.println(nums);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("no such file");
        } catch (IOException ex) {
            System.out.println("Error");
        }

        try {
            PrintWriter writer = new PrintWriter("Problems/src/test.out", "UTF-8");
            writer.print("[");
            ArrayList<ArrayList<Integer>> result = sol.buildingOutline(data);
            for (ArrayList<Integer> list : result) {
                writer.print("[");
                for (int i = 0; i < 2; i++) writer.print(list.get(i) + ",");
                writer.print(list.get(2) + "],");
            }
            writer.print("]");
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("no such file");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error");
        }
    }
}
