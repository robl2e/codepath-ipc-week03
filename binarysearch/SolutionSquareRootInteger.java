public class SolutionSquareRootInteger {
	public int sqrt(int a) {
	    // a == 11
	    if (a == 1) return 1;
	    if (a == 0) return 0;
	    
	    int left = 2;
	    int right = a/2;  //5
	    
	    while (left <= right) {
	        long mid = left + (right - left) / 2; //5 / 2 = 2
	        
	        long midNext = mid+1;
	        long next2 = midNext * midNext;
	        
//	        System.out.println("left = " + left +
//	        " right = " + right + " mid = " + mid);
	        
	        long sqr = mid * mid; // 4
	        // Found perfect square
	        if (sqr == a) {
	            return (int) mid;
	        }
	        // Imperfect square, current number < x and next number > x
	        else if (sqr < a && next2 > a) {
	            return (int) mid;
	        }
	        // Look for smaller number
	        else if (sqr > a) {
	            right = ((int)mid)-1;
	        }
	        // Look for larger number
	        else if (sqr < a) {
	            left = ((int)mid)+1;
	        }
	    }
	    return a / 2;
	}
}
