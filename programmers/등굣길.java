class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];
        boolean[][] pud = new boolean[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            pud[puddles[i][1]][puddles[i][0]] = true;
        }

        for(int i=1; i<=n; i++){
            if(pud[i][1]) break;
            map[i][1] = 1;
        }
        for(int j=1; j<=m; j++){
            if(pud[1][j]) break;
            map[1][j] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=2; j<=m; j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
                map[i][j] %= 1000000007;
                if(pud[i][j]) map[i][j] = 0;
            }
        }
        answer = map[n][m];

        return answer;
    }
}