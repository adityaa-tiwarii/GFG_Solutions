import java.util.*;

class Solution {
    public int minValue(String s, int k) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Add frequencies to max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : freqMap.values()) {
            maxHeap.add(freq);
        }

        // Step 3: Perform k removals, always from the highest frequency
        while (k > 0 && !maxHeap.isEmpty()) {
            int top = maxHeap.poll();
            if (top > 1) {
                maxHeap.add(top - 1);
            }
            k--;
        }

        // Step 4: Sum of squares of the remaining frequencies
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            int freq = maxHeap.poll();
            sum += freq * freq;
        }

        return sum;
    }

    // Optional main for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aaabccdeeeeefgg";
        int k = 7;
        int result = sol.minValue(s, k);
        System.out.println("Minimum sum of squares after removals: " + result);
    }
}