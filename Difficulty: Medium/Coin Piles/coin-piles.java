class Solution {
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);

        // Step 2: Build suffix sum array
        int[] subset = new int[n];
        subset[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            subset[i] = arr[i] + subset[i + 1];
        }

        int min = Integer.MAX_VALUE; // To store the final minimum cost
        int sum = 0; // Prefix sum

        // Step 3: Try each index as starting point
        for (int i = 0; i < n; i++) {
            // Find index of first element > arr[i] + k
            int ind = findUpper(arr, arr[i] + k, i, n - 1);

            if (ind == -1) {
                // If all elements <= arr[i]+k, update min with prefix sum
                min = Math.min(min, sum);
                continue;
            }

            // Calculate cost to reduce elements from ind to end to arr[i]+k
            int curr = subset[ind] - ((n - ind) * (arr[i] + k));
            curr += sum; // Add prefix sum

            // Update minimum answer
            min = Math.min(min, curr);

            // Update prefix sum
            sum += arr[i];
        }

        return min;
    }

    // Binary search to find index of first element > target
    static int findUpper(int[] arr, int target, int s, int e) {
        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] > target) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}