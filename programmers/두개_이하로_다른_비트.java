class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int j=0; j<numbers.length; j++){
            long number = numbers[j];

            int count = 0;
            for(long i=1; i<number; i*=2) {
                if((i&number) ==0) break;
                count++;
            }
            if(count>=2) answer[j] = number + (long) Math.pow(2, count-1);
            else answer[j] = number + 1;
        }
        return answer;
    }
}