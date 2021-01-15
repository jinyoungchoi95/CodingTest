class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<stones.length; i++){
            max = Math.max(stones[i], max);
            min = Math.min(stones[i], min);
        }
        while(min<=max){
            int mid = (max+min)/2;
            if(check(stones, k, mid)){
                answer = Math.max(answer, mid);
                min = mid+1;
            }
            else{
                max = mid-1;
            }
        }
        return answer;
    }
    public boolean check(int[] stones, int k, int mid){
        int life = k;
        for(int i=0; i<stones.length; i++){
            if(stones[i]>=mid){
                life = k;
            }
            else{
                life--;
                if(life==0) return false;
            }
        }
        return true;
    }
}