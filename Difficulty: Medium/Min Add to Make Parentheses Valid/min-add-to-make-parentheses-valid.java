class Solution {

    public int minParentheses(String s) {        

        // code here

        Stack<Character> st = new Stack<>();

        for(char c :s.toCharArray()){

            if(!st.isEmpty() && st.peek() == '(' && c == ')'){

                st.pop();

            }else{

                st.push(c);

            }

           

        }

        return st.size();

    }

}