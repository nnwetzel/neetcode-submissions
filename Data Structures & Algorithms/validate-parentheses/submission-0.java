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

            // If current character is a closing bracket
            if (p.containsKey(c)) {
                if (stack.empty() || stack.pop() != p.get(c)) return false;
            }
            else {
                stack.push(c);
            }
        }
        // Returns true if all brackets have been closed
        return stack.empty();
    }
}
