import java.util.ArrayList;
class Solution {
    public int[] solution(int n) {
        if(n==1){
            int[] answer = {1};
            return answer;
        }
        int[][] map = new int[n][n];
        int x = 0;
        int y = 0;
        map[x][y] = 1;
        while(true){
            if(map[x+1][y]!=0) break;
            while(x<n-1 && map[x+1][y]==0){
                map[x+1][y] = map[x][y] + 1;
                x++;
            }
            if(map[x][y+1]!=0) break;
            while(y<n-1 && map[x][y+1]==0){
                map[x][y+1] = map[x][y] + 1;
                y++;
            }
            if(map[x-1][y-1]!=0) break;
            while(x>0 && y>0 && map[x-1][y-1]==0){
                map[x-1][y-1] = map[x][y] + 1;
                x--;
                y--;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]!=0) list.add(map[i][j]);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}