public class SolutionDistinctNumbersWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        if (B > A.size()) return new ArrayList<Integer>();
        

        HashMap<Integer, Integer> intCountMap
            = new HashMap<>();
        ArrayList<Integer> distinctList = new ArrayList<>();
        int distinctCount = 0;
        
        // Create First Window
        List<Integer> firstWindow = A.subList(0, B);
        for (Integer num : firstWindow) {
            if (intCountMap.containsKey(num)) {
                int count = intCountMap.get(num);
                count++;
                intCountMap.put(num, count);
            } else {
                intCountMap.put(num, 1);
            }   
        }
        distinctCount = intCountMap.size();
        distinctList.add(distinctCount);

        // Shift Window 
        for (int i = B; i < A.size(); i++) {
            int firstElement = A.get(i-B);
            // Remove first element if only 1
            if (intCountMap.get(firstElement) == 1) {
                intCountMap.remove(firstElement);
                distinctCount--;
            } 
            // Otherwise Lower count
            else {
                int count = intCountMap.get(firstElement);
                count--;
                intCountMap.put(firstElement, count);
            }
            
            // Insert current element
            int curElement = A.get(i);
            if (intCountMap.containsKey(curElement)) {
                int count = intCountMap.get(curElement);
                count++;
                intCountMap.put(curElement, count);
            } else {
                intCountMap.put(curElement, 1);
                distinctCount++;
            }
            distinctList.add(distinctCount);
        }
        return distinctList;
    }
}
