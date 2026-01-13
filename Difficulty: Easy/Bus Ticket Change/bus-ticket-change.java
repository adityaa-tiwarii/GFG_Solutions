class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int five = 0;
        int ten = 0;
        for(int ticket : arr)
        {
            if(ticket == 5)
            {
            five++;
            }
            else if(ticket == 10)
            {
            if(five>0)
            {
             five--;
             ten++;
            }
             else
              return false;
            }
             else
             {
                 
                 if(ten >0 && five>0)
                  {
                      ten--;
                      five--;
                  }
                else if(five >=3)
                  five = five - 3;
                  else
                  return false;
                  
             }
        }
        return true;
    }
}