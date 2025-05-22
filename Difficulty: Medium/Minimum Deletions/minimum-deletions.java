class Solution {

   static int minDeletions(String s) {

        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        
        return  s.length()-recurse(0,s.length()-1,dp,s);
    }
    
    static int recurse(int i,int j,int dp[][],String s){
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            
            int a=recurse(i+1,j-1,dp,s)+2;
            return dp[i][j]=a;
        }
        else{
            int a=recurse(i+1,j,dp,s);
            int b=recurse(i,j-1,dp,s);
            dp[i][j]=Math.max(a,b);
            return dp[i][j];
        }
    }
}