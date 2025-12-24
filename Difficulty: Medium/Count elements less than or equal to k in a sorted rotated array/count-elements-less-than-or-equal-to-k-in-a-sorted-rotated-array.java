class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
         int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=x){
                count++;
            }
        }
        return count;
        
    }
}