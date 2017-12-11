public class SolutionSortedInsertPosition {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    if (a == null || a.isEmpty()) return 0;
	    
	    Integer target = binarySearch(a,b);
	    if (target != null) {
	        return target;
	    }
	    
	    target = findSearchIndex(a, b);
 	    return target;
	}
	
	public Integer findSearchIndex(ArrayList<Integer> a, int b) {
	    int left = 0;
	    int right = a.size()-1;
	    
	    while (left <= right) {
	        int mid = left + (right-left)/2;
	        int num = a.get(mid);
	        
	        int nextMid = mid+1;
	        int prevMid = mid-1;
	        
	        // Beyond End
	        if (nextMid >= a.size()) {
	            return nextMid;
	        }
	        
	        // Beyond Begin
	        if (prevMid < 0) {
	            return 0;
	        }
	        
 	        int nextNum = a.get(nextMid);
 	        int prevNum = a.get(prevMid);
 	        
 	        /*
 	        System.out.println("prevNum = " + prevNum +
 	            " num = " + num +
 	            " nextNum = " + nextNum +
 	            " b = " + b
 	        );
 	        */
	        
	        if (b > num && b < nextNum) {
	            return nextMid;
	        } else if (b < num && b > prevNum) {
	            return mid;
	        } else if (b > num) {
	            left = mid+1;
	        } else if (b < num) {
	            right = mid-1;
	        }
	    }
	    return null;
	}
	
	public Integer binarySearch(ArrayList<Integer> a, int b) {
	    int left = 0;
	    int right = a.size()-1;
	    
	    while (left <= right) {
	        int mid = left + (right-left)/2;
	        int num = a.get(mid);
	        
	        if (num == b) {
	            return mid;
	        } else if (b > num) {
	            left = mid+1;
	        } else if (b < num) {
	            right = mid-1;
	        }
	    }
	    return null;
	}
}
