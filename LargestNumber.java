package techsilicon.demo;

import java.util.Arrays;

public class LargestNumber {
	
	public static void main(String[] a){
		
		int largestNumber = solution(779);
		
		System.out.println("largestNumber: "+ largestNumber);
	}
	
    public static int solution(int N) {
        // write your code in Java SE 8
    	
        int[] counter = new int[10];
        while (N != 0) {
            if (N == 0) {
                break;
            }
            int val = N % 10;
            System.out.println("val: "+val);
            counter[val]++;
            System.out.println("counter::::"+Arrays.toString(counter));
            N /= 10;
            System.out.println("N: "+N);
        }
        System.out.println(Arrays.toString(counter));
        int largestNum = 0;
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < counter[i]; j++) {
                largestNum = largestNum * 10 + i;
                System.out.println("j: "+j);
                System.out.println("largestNum: "+largestNum);
            }
        }
        return largestNum;
    }

}
