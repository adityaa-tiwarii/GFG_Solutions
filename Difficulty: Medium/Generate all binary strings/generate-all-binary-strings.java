class Solution {
    
    void solve(ArrayList<String> ans , int indx,int n,String[] st){
        if(indx == n){
            ans.add(st[0]);
            return;
        }
        
        // append 0;
        st[0] = st[0] + "0";
        solve(ans,indx+1,n,st);
        
        // remove appended 0
        st[0] = st[0].substring(0,st[0].length()-1);
        
        // append 1
        st[0] = st[0]+"1";
        solve(ans,indx+1,n,st);
        
        // remove appended 1
        st[0] = st[0].substring(0,st[0].length()-1);
    }
    public ArrayList<String> binstr(int n) {
        // code here
        String[] st = new String[1];
        st[0] = "";
        ArrayList<String> ans = new ArrayList();
        
        solve(ans,0,n,st);
        
        return ans;
        
    }
}