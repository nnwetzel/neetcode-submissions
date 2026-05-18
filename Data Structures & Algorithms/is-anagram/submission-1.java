class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Hashtable<Character, Integer> frequencyCount1 = new Hashtable<>();
        Hashtable<Character, Integer> frequencyCount2 = new Hashtable<>();
        
        for (int i = 0; i < s.length(); i++) {
            frequencyCount1.put(s.charAt(i), frequencyCount1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            frequencyCount2.put(t.charAt(j), frequencyCount2.getOrDefault(t.charAt(j), 0) + 1);
        }
        return frequencyCount1.equals(frequencyCount2);
    }
}
