class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            if(check(i)) answer -= i;
            else answer += i;
        }
        return answer;
    }
    public boolean check(int num) {
        if(num == (int)Math.sqrt(num) *(int)Math.sqrt(num)) return true;
        return false;
    }
}