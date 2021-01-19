class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] map) {
        int answer = 0;
        int[][] down = new int[m+1][n+1];
        int[][] right = new int[m+1][n+1];
        down[1][1] = 1;
        right[1][1] = 1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(map[i-1][j-1]==0){
                    down[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
                    right[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
                }
                else if(map[i-1][j-1]==2){
                    down[i][j] += down[i-1][j] % MOD;
                    right[i][j] += right[i][j-1] % MOD;
                }
            }
        }
        answer = (down[m-1][n] + right[m][n-1]) % MOD;
        return answer;
    }
}