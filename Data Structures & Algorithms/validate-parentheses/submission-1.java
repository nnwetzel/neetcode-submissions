class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> p = new HashMap<>();
        p.put(')', '(');
        p.put('}', '{');
        p.put(']', '[');

        // Use a stack to keep track of open brackets that need to be closed
        // If we find a closing bracket, but there is no matching open bracket in the
        // stack? Return false!
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the curr char is a closing bracket, it must be matched with an opening bracket in the stack!
            if (p.containsKey(c)) {
                // Stack might be empty OR does not have the opening bracket to cancel out the closing bracket!
                if (stack.empty() || stack.pop() != p.get(c)) {
                    return false;
                }
            }
            // If the current is not a closing bracket (might be an opening bracket, add it to the stack to be closed eventually)
            else {
                    stack.push(c);
                }
        }
        return stack.empty();
    }
}
