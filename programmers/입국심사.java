import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);

        long max = (long) times[times.length-1] * n;
        long min = 1;

        while(min<=max){
            long mid = (max+min) / 2;

            long sum = 0;
            for(int i=0; i<times.length; i++){
                sum += mid/times[i];
            }

            if(sum>=n){
                if(mid<answer) answer = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return answer;
    }
}