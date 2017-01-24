package techsilicon.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution{
	
	    /// <summary>
	    /// Return total stops used
	    /// </summary>
	    /// <param name="A">weight of people</param>
	    /// <param name="B">floors they need to get down</param>
	    /// <param name="M">total floors in the building</param>
	    /// <param name="X">Max people to carry at a time</param>
	    /// <param name="Y">max weight to carry at a time</param>
	    /// <returns></returns>
	
	
	public static void main(String a[]){
		
		int[] A = {60,80,40};
		int[] B = {2,3,5};
		
		int totalStops = solution(A,B,5,2,200);
		
		System.out.println("Total Stops :" + totalStops);
		
	}
	public static int solution(int[] A, int[] B, int M, int X, int Y){
	        
		int totalStopsByLift = 0;
	        long weightInLiftPerTrip = 0;
	        int personsCounter = 0;
	        List<Integer> lstFloors = new ArrayList<Integer>();
	        int currPerson = 0;
	        boolean startLift = false;
	        System.out.println("A.length:::" + A.length);
	        while (currPerson < A.length)
	        {
	        	System.out.println("weightInLiftPerTrip:::" + weightInLiftPerTrip);
	        	System.out.println("personsCounter:::" + personsCounter);
	        	System.out.println("currPerson:::" + currPerson+"\n");
	            if ((weightInLiftPerTrip + A[currPerson]) <= Y && (personsCounter+1) <= X)
	            {
	                weightInLiftPerTrip += A[currPerson];
	                personsCounter++;
	                lstFloors.add(B[currPerson]);
	                System.out.println("weightInLiftPerTrip:::" + weightInLiftPerTrip);
	                System.out.println("personsCounter:::" + personsCounter);
	                System.out.println("lstFloors:::" + lstFloors);
	                if (currPerson == A.length - 1)
	                    startLift = true;
	                System.out.println("startLift:::" + startLift+"\n");
	                currPerson++;
	            }
	            else
	            {
	                startLift = true;
	            }
	            if (startLift)
	            {
	            	Set set = new HashSet(lstFloors);
	            	ArrayList uniqueList = new ArrayList(set);
	                
	            	totalStopsByLift += uniqueList.size() +1;
	            	System.out.println("totalStopsByLift::" + totalStopsByLift+"\n");
	                lstFloors.clear();
	                personsCounter = 0;
	                weightInLiftPerTrip = 0;
	                startLift = false;
	            }
	        }
	        return totalStopsByLift;
	   }
}
