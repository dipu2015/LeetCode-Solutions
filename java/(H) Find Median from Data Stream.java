// Need to reorganize the code

class MedianFinder {

    PriorityQueue<Integer> smallQueue = new PriorityQueue<Integer>(Collections.reverseOrder()); // !!
    PriorityQueue<Integer> largeQueue = new PriorityQueue<Integer>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (smallQueue.size() == 0 && largeQueue.size() == 0) {
            smallQueue.add(num);
        }
        else if (smallQueue.size() == 0) {
            int v = largeQueue.peek();
            if (num <= v) {
                smallQueue.add(num);
            }
            else {
                int top = largeQueue.poll();
                largeQueue.add(num);
                smallQueue.add(top);
            }
        }
        else if (largeQueue.size() == 0) {
            int v = smallQueue.peek();
            if (num >= v) {
                largeQueue.add(num);
            }
            else {
                int top = smallQueue.poll();
                smallQueue.add(num);
                largeQueue.add(top);
            }
        }
        else {
            int v1 = smallQueue.peek();
            int v2 = largeQueue.peek();
            if (num >= v1 && num <= v2) {
                if(smallQueue.size() <= largeQueue.size())
                    smallQueue.add(num);
                else
                    largeQueue.add(num);
            }
            else if (num < v1) {
                if(smallQueue.size() <= largeQueue.size())
                    smallQueue.add(num);
                else {
                    largeQueue.add(smallQueue.poll());
                    smallQueue.add(num);
                }
            }
            else {
                if(smallQueue.size() > largeQueue.size())
                    largeQueue.add(num);
                else {
                    smallQueue.add(largeQueue.poll());
                    largeQueue.add(num);
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (smallQueue.size() > largeQueue.size())
            return smallQueue.peek();
        else if (smallQueue.size() < largeQueue.size())
            return largeQueue.peek();
        else
            return (double)(smallQueue.peek() + largeQueue.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
