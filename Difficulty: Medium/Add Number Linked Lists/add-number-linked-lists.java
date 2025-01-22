//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    
    public static Node reverse(Node head){
        Node prev = null;
        while(head!=null){
            Node next = head.next;
            head.next =prev;
            prev = head;
            head = next;
            
        }
        return prev;
    }
    static Node addTwoLists(Node num1, Node num2) {
        while(num1!=null){
            if(num1.data!=0)
                break;
            else
                num1 = num1.next;
        }
        while(num2!=null){
            if(num2.data!=0)
                break;
            else
                num2 = num2.next;
        }
        if(num1==null)
            return num2;
        if(num2==null)
            return num1;
        
        num1 = reverse(num1);
        num2 = reverse(num2);
        Node dummy = new Node(-1);
        Node dummy1 = dummy;
        int carry = 0;
        
        while(num1!=null || num2!=null){
            int a = num1!=null?num1.data:0;
            int b = num2!=null?num2.data:0;
            int x = (a+b+carry)%10;
            carry = (a+b+carry)/10;
            dummy1.next = new Node(x);
            dummy1 = dummy1.next;
            if(num1!=null)
                num1= num1.next;
            if(num2!=null)
                num2 = num2.next;
        }
        if(carry!=0)
            dummy1.next = new Node(carry);
        
        return reverse(dummy.next);
        
        
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends