package practice.task;


public class LargestNumber {
	
	public static void main(String[] a){
		
		int largestNumber = solution(779);
		
		System.out.println("largestNumber: "+ largestNumber);
	}
	
    public static int solution(int N) {
    	
        int[] counter = new int[10];
        while (N != 0) {
            if (N == 0) {
                break;
            }
            int val = N % 10;
            counter[val]++;
            N /= 10;
        }
        int largestNum = 0;
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < counter[i]; j++) {
                largestNum = largestNum * 10 + i;
            }
        }
        return largestNum;
    }
}
