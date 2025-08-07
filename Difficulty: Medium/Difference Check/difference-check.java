class Solution {
    public int minDifference(String[]arr) {
        // code here
    int [] timelnSeconds = new int[arr.length];
    for(int i=0;i<arr.length;i++)
    {
        String[] parts = arr[i].split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        timelnSeconds[i]= hours * 3600 + minutes * 60 + seconds;
    }

    Arrays.sort(timelnSeconds);
    int minDiff = Integer.MAX_VALUE;
    int n = timelnSeconds.length;

        

        // Compare adjacent times
        for (int i = 0; i < n-1; i++) {
            int diff =timelnSeconds [i+1] - timelnSeconds[i];
            minDiff = Math.min(minDiff,diff);
        }

        // Check the wrap-around case (last and first)
        int lastToFirst = (86400 - timelnSeconds[n - 1]) + timelnSeconds[0]; // 86400 = total seconds in a day
        minDiff = Math.min(minDiff,lastToFirst);

        return minDiff;
    }

 }