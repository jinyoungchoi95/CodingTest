class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[m][n];
        boolean[][] puddle = new boolean[m][n];
        for(int i=0; i<puddles.length; i++){
            puddle[puddles[i][0]-1][puddles[i][1]-1] = true;
        }

        for(int i=0; i<m; i++){
            if(puddle[i][0]) break;
            dp[i][0] = 1;
        }
        for(int i=0; i<n; i++){
            if(puddle[0][i]) break;
            dp[0][i] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(puddle[i][j]) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1000000007;
            }
        }

        answer = dp[m-1][n-1];
        return answer;
    }
}