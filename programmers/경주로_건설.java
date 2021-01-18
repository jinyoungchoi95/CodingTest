import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][] map = new int[n][n];

        Queue<index> queue = new LinkedList<>();
        if(board[0][1]==0){
            queue.add(new index(0,1,3,100));
            map[0][1] = 100;
        }
        if(board[1][0]==0){
            queue.add(new index(1,0,1,100));
            map[1][0] = 100;
        }

        while(!queue.isEmpty()){
            index tmp = queue.poll();
            if(tmp.money>answer) continue;
            if(tmp.x==n-1 && tmp.y==n-1){
                answer = Math.min(answer, map[n-1][n-1]);
                continue;
            }

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=n || board[nx][ny]==1){
                    continue;
                }

                if(tmp.d==i){
                    int m = tmp.money + 100;
                    if(map[nx][ny]==0 || m <= map[nx][ny]){
                        map[nx][ny] = m;
                        queue.add(new index(nx, ny, i, m));
                    }
                }
                else{
                    int m = tmp.money + 600;
                    if(map[nx][ny]==0 || m <= map[nx][ny]){
                        map[nx][ny] = m;
                        queue.add(new index(nx, ny, i, m));
                    }
                }
            }
        }


        return answer;
    }
    public class index{
        int x;
        int y;
        int d;
        int money;
        public index(int x, int y, int d, int money){
            this.x = x;
            this.y = y;
            this.d = d;
            this.money = money;
        }
    }
}