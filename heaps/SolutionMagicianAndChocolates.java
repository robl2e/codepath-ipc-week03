public class SolutionMagicianAndChocolates {
    /*
        A = unit of time
        B = bags of num chocolates
    */
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<Integer>(Collections.reverseOrder());
            maxHeap.addAll(B);
        double eatCount = 0;
    
        for (int i = 0; i < A; i++) {
           int numChoc = maxHeap.poll();
           eatCount += numChoc;
           
           int halfChoc = numChoc/2;
           maxHeap.offer(halfChoc);
        }
        double intResult = Math.pow(10, 9) + 7;
        return (int)(eatCount % intResult);
    }
}
