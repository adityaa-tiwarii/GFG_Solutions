/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    static int maxSum=0,maxLevel=0;
    
    static void func(Node root,int sum,int currLevel)
    {
        if(root==null)
            return;
        sum+=root.data;
        currLevel++;
        func(root.left,sum,currLevel);
        func(root.right,sum,currLevel);
        
        if(currLevel>maxLevel)
        {
            maxSum=sum;
            maxLevel=currLevel;
        }
        else if(currLevel==maxLevel)
        {
            maxSum=Math.max(maxSum,sum);
            //maxLevel and currLevel are already same
        }
    }
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        int sum=0;
        int currLevel=0;
        
        maxSum=0;// need to redeclare its values as 0
        maxLevel=0;
        //static variables are shared across all instances 
        //of a class and persist as long as the program 
        //is running 
        
        func(root,sum,currLevel);
        return maxSum;    
    }
}