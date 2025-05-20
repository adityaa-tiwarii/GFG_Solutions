/*
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution {
  public:
    int mul=100000;
    bool flag=false;
    int ans=0;
    int bottom=0;
    int tar;
    
    long long int postorder(Node* root){
        if(root==NULL){
            return 0;
        }
        
        long long int left=postorder(root->left);
        long long int right=postorder(root->right);
        
        if(root->data==tar){
            ans=max(left,right);
            bottom=ans;
            return mul;
        }
        
        if(left>=mul||right>=mul){
            int height=0;
            int top=0;
            if(left>=mul){
               height=left/mul;
               top=height+right;
            }
            else if(right>=mul){
               height=right/mul;
               top=height+left;
            }
            
            ans=max(ans,max(bottom,top));
            return (height+1)*mul;
        }
        
        return max(left,right)+1;
    }
    
    int minTime(Node* root, int target) {
        // code here
        tar=target;
        postorder(root);
        return ans;
    }
};

