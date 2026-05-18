class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        // calculates frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min-heap: keeps least frequency element at top
        // Comparator: (n1, n2) -> freq.get(n1) - freq.get(n2) means sort by frequency
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> freq.get(n1) - freq.get(n2));

        // Keep only k most frequency elements in heap
        for (int n : freq.keySet()) {
            heap.add(n);

            // If heap exceeds k elements, remove least frequent (top of min-heap)
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            top[i] = heap.poll(); // Most frequency elements come out last
        }

        return top;
    }
}
