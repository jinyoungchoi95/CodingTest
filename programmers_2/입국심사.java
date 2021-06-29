import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);
        long min = 1;
        long max = (long) times[times.length-1] * (n/times.length);

        while(min <= max) {
            long mid = (min + max) / 2;

            long sum = 0;
            for(int i=0; i<times.length; i++){
                sum += mid / times[i];
            }

            if(sum >= n){
                answer = Math.min(answer, mid);
                max = mid - 1;
            }
            else {
                min = mid + 1;
            }
        }

        return answer;
    }
}