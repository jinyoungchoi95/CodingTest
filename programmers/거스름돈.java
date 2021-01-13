class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;

        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<money.length; i++){
            int num = money[i];
            for(int j=0; j+num<=n; j++){
                dp[j+num] += dp[j];
                dp[j+num] %= 1000000007;
            }
        }
        answer = dp[n];
        return answer;
    }
}