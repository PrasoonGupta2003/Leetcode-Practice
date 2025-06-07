import java.util.*;

public class MaxDistinctTripleSum {
    public static int maxSum(int[] x, int[] y) {
        int n = x.length;
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Map each x to the max y for that x
        for (int i = 0; i < n; i++) {
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }

        // Step 2: Add all max y values to a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : map.values()) {
            pq.add(val);
        }

        // Step 3: Pick the top 3 max y values if possible
        if (pq.size() < 3) return -1;
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] x1 = {1, 2, 1, 3, 2};
        int[] y1 = {5, 3, 4, 6, 2};
        System.out.println(maxSum(x1, y1));  // Output: 14

        int[] x2 = {1, 2, 1, 2};
        int[] y2 = {4, 5, 6, 7};
        System.out.println(maxSum(x2, y2));  // Output: -1
    }
}
