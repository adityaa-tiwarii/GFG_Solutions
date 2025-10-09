class Solution {
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        if(root == null) return list;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.data);
        
        return list;
        
    }
}