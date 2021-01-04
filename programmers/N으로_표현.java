class Solution {
    public int answer;
    public int solution(int N, int number) {
        answer = 9;

        dfs(0, 0, N, number);

        if(answer==9) return -1;
        return answer;
    }
    public void dfs(int count, int maked, int N, int number){
        if(count>8){
            return;
        }
        if(maked==number){
            answer = Math.min(answer, count);
            return;
        }
        for(int i=1; i<=8-count; i++){
            dfs(count+i, maked + make(i,N), N, number);
            dfs(count+i, maked - make(i,N), N, number);
            dfs(count+i, maked * make(i,N), N, number);
            dfs(count+i, maked / make(i,N), N, number);
        }
    }
    public int make(int i, int N){
        int result = 0;
        for(int j=0; j<i; j++){
            result += Math.pow(10,j)*N;
        }
        return result;
    }
}