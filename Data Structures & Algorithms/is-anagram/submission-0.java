class Solution {
    public boolean isAnagram(String s, String t) {
        Hashtable<Character, Integer> frequencyCount1 = new Hashtable<>();
        Hashtable<Character, Integer> frequencyCount2 = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            if (frequencyCount1.containsKey(s.charAt(i))) {
                frequencyCount1.put(s.charAt(i), frequencyCount1.get(s.charAt(i)) + 1);
            }
            else {
                frequencyCount1.put(s.charAt(i), 1);
            }
        }
        for (int j = 0; j < t.length(); j++) {
            if (frequencyCount2.containsKey(t.charAt(j))) {
                frequencyCount2.put(t.charAt(j), frequencyCount2.get(t.charAt(j)) + 1);
            }
            else {
                frequencyCount2.put(t.charAt(j), 1);
            }
        }
        return frequencyCount1.equals(frequencyCount2);
    }
}
