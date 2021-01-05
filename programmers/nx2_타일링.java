class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==1) return 1;
        else if(n==2) return 2;
        else if(n==3) return 3;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        answer = dp[n];
        return answer;
    }
}