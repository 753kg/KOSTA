package codility;
import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		int[] A = {0, 3, 2};
		int result = new Solution().solution(A);
		System.out.println(result);
	}
	
	static class Solution {
	    public int solution(int[] A) {
	    	Arrays.sort(A);
	  	        
	    	if(A[A.length-1] <= 0) return 1;
	        
	    	int result = 1;
	        for(int i=0; i<A.length; i++){
	            if(A[i] > 0 && A[i] == result) result++;
	        }
	        
	        return result;
	    }
	}

}