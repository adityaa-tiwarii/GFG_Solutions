//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;

            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }

            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head);
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    Node reverseList(Node head) {
        Node prev = null;  // Initialize previous pointer to null
        Node curr = head;  // Initialize current pointer to head of the list
        Node next = null;  // Initialize next pointer to null
        
        // Traverse the linked list and reverse the links
        while (curr != null) {
            next = curr.next;      // Store the next node
            curr.next = prev;      // Reverse the current node's next pointer
            prev = curr;           // Move prev pointer one step forward
            curr = next;           // Move curr pointer one step forward
        }
        
        // At the end, prev will be pointing to the new head of the reversed list
        return prev;
    }
}
