class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        int n = arr.length;
        int idx = 0;

        // Find the closest index <= x (not necessarily x itself)
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                idx = i - 1;
                break;
            }
            idx = i;
        }

        int result[] = new int[k];
        int p = 0;

        int i = idx;
        int j = idx + 1;

        while (i >= 0 && j < n && p < k) {
            // Skip x itself if present
            if (arr[i] == x) {
                i--;
                continue;
            }
            if (arr[j] == x) {
                j++;
                continue;
            }

            int valA = Math.abs(x - arr[i]);
            int valB = Math.abs(x - arr[j]);

            if (valA < valB) {
                result[p++] = arr[i--];
            } else if (valA > valB) {
                result[p++] = arr[j++];
            } else {
                // If equal distance, choose greater element
                if (arr[i] > arr[j]) {
                    result[p++] = arr[i--];
                } else {
                    result[p++] = arr[j++];
                }
            }
        }

        while (p < k && i >= 0) {
            if (arr[i] != x) result[p++] = arr[i];
            i--;
        }

        while (p < k && j < n) {
            if (arr[j] != x) result[p++] = arr[j];
            j++;
        }

        return result;
    }
}