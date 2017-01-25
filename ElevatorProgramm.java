package practice.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElevatorProgramm{
	
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
	        while (currPerson < A.length)
	        {
	            if ((weightInLiftPerTrip + A[currPerson]) <= Y && (personsCounter+1) <= X)
	            {
	                weightInLiftPerTrip += A[currPerson];
	                personsCounter++;
	                lstFloors.add(B[currPerson]);
	                if (currPerson == A.length - 1)
	                    startLift = true;
	                currPerson++;
	            }
	            else
	            {
	                startLift = true;
	            }
	            if (startLift)
	            {
	            	Set<Integer> set = new HashSet<Integer>(lstFloors);
	            	ArrayList<Integer> uniqueList = new ArrayList<Integer>(set);
	                
	            	totalStopsByLift += uniqueList.size() +1;
	                lstFloors.clear();
	                personsCounter = 0;
	                weightInLiftPerTrip = 0;
	                startLift = false;
	            }
	        }
	        return totalStopsByLift;
	   }
}
