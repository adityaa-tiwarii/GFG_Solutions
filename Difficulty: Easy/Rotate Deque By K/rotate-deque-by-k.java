class Solution {
   // public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        // code here
        public static void main(String[] args) {
        
        Deque<Integer> dq1 = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        rotateDeque(dq1, 1, 2);
        System.out.println(dq1); // [5, 6, 1, 2, 3, 4]

        
        Deque<Integer> dq2 = new ArrayDeque<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateDeque(dq2, 2, 3);
        System.out.println(dq2); 
    }

    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return;

        k = k % n; 
        if (k == 0) return;

        
        List<Integer> list = new ArrayList<>(dq);
        dq.clear();

        if (type == 1) {
            dq.addAll(list.subList(n - k, n)); 
            dq.addAll(list.subList(0, n - k)); 
        } else if (type == 2) {
            dq.addAll(list.subList(k, n)); 
            dq.addAll(list.subList(0, k)); 
        }

    }
}

