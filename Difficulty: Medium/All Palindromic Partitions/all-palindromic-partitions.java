class Solution {
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(String s,int idx,
    ArrayList<String> curr,ArrayList<ArrayList<String>> res)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            if(isPalin(s,idx,i))
            {
                curr.add(s.substring(idx,i+1));
                backtrack(s,i+1,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
    private boolean isPalin(String s,int low,int high)
    {
        while(low<high)
        {
            if(s.charAt(low++)!=s.charAt(high--))
            return false;
        }
        return true;
    }
}