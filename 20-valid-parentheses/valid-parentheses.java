import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // 1. If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // 2. If it's a closing bracket, check the top of the stack
            else {
                // If stack is empty, a closing bracket appeared without an opening one
                if (stack.isEmpty()) {
                    return false;
                }
                
                char lastOpened = stack.pop();
                
                // CRITICAL CHECK: The closing bracket MUST match the last opened bracket
                if (ch == ')' && lastOpened != '(') return false;
                if (ch == '}' && lastOpened != '{') return false;
                if (ch == ']' && lastOpened != '[') return false;
            }
        }
        
        // If the stack is empty, everything matched up perfectly
        return stack.isEmpty();
    }
}
