//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Node root = null;

            // Read inorder array
            String[] inorderStr = (br.readLine()).trim().split(" ");
            int inorder[] = new int[inorderStr.length];
            for (int i = 0; i < inorderStr.length; i++) {
                inorder[i] = Integer.parseInt(inorderStr[i]);
            }

            // Read preorder array
            String[] preorderStr = (br.readLine()).trim().split(" ");
            int preorder[] = new int[preorderStr.length];
            for (int i = 0; i < preorderStr.length; i++) {
                preorder[i] = Integer.parseInt(preorderStr[i]);
            }

            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder);
            postOrder(root);
            System.out.println();
        }
    }

    // Function to print postorder traversal of the tree
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}

// } Driver Code Ends


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/


/*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
       }
       int[] curr = {0};
       return recursion(map, preorder, curr,0, inorder.length - 1);
    }

    public static Node recursion(Map<Integer, Integer> inorderMap, int[] preoder, int[] curr, int start, int end) {

        if (start > end) {
            return null;
        }

        int idx = inorderMap.get(preoder[curr[0]]);
        Node node = new Node(preoder[curr[0]]);
        curr[0]++;
        node.left = recursion(inorderMap, preoder,curr, start, idx-1);
        node.right = recursion(inorderMap, preoder, curr, idx + 1, end);
        return node;

    }
}