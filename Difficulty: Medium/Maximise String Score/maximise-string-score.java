import java.util.*;

class Solution {
    public int maxScore(String s, char[][] jumps) {
        int n = s.length();
        char[] chars = s.toCharArray();
        
        // Precompute next occurrence of each character
        int[] nextSameChar = new int[n];
        Arrays.fill(nextSameChar, -1);
        
        Map<Character, Integer> lastPos = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            nextSameChar[i] = lastPos.getOrDefault(chars[i], -1);
            lastPos.put(chars[i], i);
        }
        
        // Build jump map
        Map<Character, List<Character>> jumpMap = new HashMap<>();
        for (char[] jump : jumps) {
            jumpMap.computeIfAbsent(jump[0], k -> new ArrayList<>()).add(jump[1]);
        }
        
        // Precompute positions for each character
        Map<Character, List<Integer>> charPositions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            charPositions.computeIfAbsent(chars[i], k -> new ArrayList<>()).add(i);
        }
        
        // Precompute prefix sums
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + chars[i];
        }
        
        // DP array
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return dfs(0, chars, nextSameChar, jumpMap, charPositions, prefixSum, dp);
    }
    
    private int dfs(int idx, char[] chars, int[] nextSameChar,
                   Map<Character, List<Character>> jumpMap,
                   Map<Character, List<Integer>> charPositions,
                   int[] prefixSum, int[] dp) {
        int n = chars.length;
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];
        
        int maxScore = 0;
        char currentChar = chars[idx];
        
        // Option 1: Jump to next same character
        int nextSame = nextSameChar[idx];
        if (nextSame != -1) {
            int score = calculateScore(idx, nextSame, chars, prefixSum);
            maxScore = Math.max(maxScore, score + dfs(nextSame, chars, nextSameChar, 
                                                     jumpMap, charPositions, prefixSum, dp));
        }
        
        // Option 2: Jump according to rules
        if (jumpMap.containsKey(currentChar)) {
            for (char targetChar : jumpMap.get(currentChar)) {
                List<Integer> positions = charPositions.get(targetChar);
                if (positions != null) {
                    // Use binary search to find first position > idx
                    int posIndex = Collections.binarySearch(positions, idx);
                    if (posIndex < 0) posIndex = -posIndex - 1;
                    
                    // Only consider a limited number of positions to avoid O(n²)
                    for (int i = posIndex; i < Math.min(posIndex + 3, positions.size()); i++) {
                        int nextPos = positions.get(i);
                        if (nextPos > idx) {
                            int score = calculateScore(idx, nextPos, chars, prefixSum);
                            maxScore = Math.max(maxScore, score + dfs(nextPos, chars, nextSameChar,
                                                                     jumpMap, charPositions, prefixSum, dp));
                        }
                    }
                }
            }
        }
        
        // Option 3: Stay at current position (no jump) - end sequence
        maxScore = Math.max(maxScore, 0);
        
        dp[idx] = maxScore;
        return maxScore;
    }
    
    private int calculateScore(int i, int j, char[] chars, int[] prefixSum) {
        char targetChar = chars[j];
        int total = prefixSum[j] - prefixSum[i];
        
        // Subtract characters equal to targetChar in range [i, j-1]
        // We can optimize this by precomputing prefix sums for each character
        for (int k = i; k < j; k++) {
            if (chars[k] == targetChar) {
                total -= chars[k];
            }
        }
        
        return total;
    }
}