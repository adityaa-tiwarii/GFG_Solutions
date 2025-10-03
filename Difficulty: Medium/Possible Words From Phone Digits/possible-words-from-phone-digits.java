class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        String[] chr= new String[]{"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> list= new ArrayList<String>();
        int flag=0;
        for(int i: arr)
        {
            if(i==0 || i==1)
            {
                continue;
            }
            ArrayList<String> l1= new ArrayList<String>();
            for(int j=0; j<chr[i].length(); j++)
            {
                String st= String.valueOf(chr[i].charAt(j));
                if(flag==0)
                {
                    list.add(st);
                    continue;
                }
                for(String st1 : list)
                {
                    String st2= st1.concat(st);
                    l1.add(st2);
                }
            }
            if(flag==1)
            {
                list.clear();
                list.addAll(l1);
                l1.clear();
            }
            flag=1;
        }
        return list;
    }
}