class MedianFinder {
    Queue<Integer> lower;
    Queue<Integer> upper;

    public MedianFinder() {
        lower = new PriorityQueue<>(Collections.reverseOrder());
        upper = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
        }
        else {
            upper.offer(num);
        }

        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        }
        else if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }
    
    public double findMedian() {
        if (lower.size() == upper.size()) {
            return ((long) lower.peek() + (long) upper.peek()) / 2.0;
        }
        return lower.peek();
    }
}
