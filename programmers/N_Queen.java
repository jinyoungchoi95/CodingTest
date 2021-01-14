class Solution {
    public int answer;
    public int solution(int n) {
        answer = 0;
        boolean[][] map = new boolean[n][n];

        dfs(n, map, 0);

        return answer;
    }
    public void dfs(int n, boolean[][] map, int x){
        if(x==n){
            answer++;
            return;
        }

        for(int j=0; j<n; j++){
            if(up(map,x,j) && dia_left(map,x,j) && dia_right(map,x,j,n)){
                map[x][j] = true;
                dfs(n, map, x+1);
                map[x][j] = false;
            }
        }
    }
    public boolean up(boolean[][] map, int x, int y){
        int i = x-1;
        int j = y;
        while(i>=0){
            if(map[i][j]) return false;
            i--;
        }
        return true;
    }
    public boolean dia_left(boolean[][] map, int x, int y){
        int i = x-1;
        int j = y-1;
        while(i>=0 && j>=0){
            if(map[i][j]) return false;
            i--;
            j--;
        }
        return true;
    }
    public boolean dia_right(boolean[][] map, int x, int y, int n){
        int i = x-1;
        int j = y+1;
        while(i>=0 && j<n){
            if(map[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }

}