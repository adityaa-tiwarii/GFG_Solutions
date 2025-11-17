import java.util.*;

class Solution {
    // Fenwick Tree (BIT)
    static class Fenwick {
        long[] bit;
        Fenwick(int n) {
            bit = new long[n+1];
        }

        void update(int idx, long val) {
            while (idx < bit.length) {
                bit[idx] = Math.max(bit[idx], val);
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long res = 0;
            while (idx > 0) {
                res = Math.max(res, bit[idx]);
                idx -= idx & -idx;
            }
            return res;
        }
    }

    public int maxSumIS(int[] arr) {
        int n = arr.length;

        // Step 1: Coordinate Compression
        int[] comp = arr.clone();
        Arrays.sort(comp);
        Map<Integer, Integer> compress = new HashMap<>();

        int id = 1;
        for (int x : comp) {
            if (!compress.containsKey(x)) {
                compress.put(x, id++);
            }
        }

        // BIT size = unique numbers count
        Fenwick bit = new Fenwick(id);

        long ans = 0;

        // Step 2: Process each number
        for (int x : arr) {
            int idx = compress.get(x);

            // Query best sum for smaller values
            long best = bit.query(idx - 1);

            long currSum = best + x;

            // Update BIT with current value
            bit.update(idx, currSum);

            ans = Math.max(ans, currSum);
        }

        return (int) ans;
    }
}