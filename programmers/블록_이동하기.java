import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean[][][][] visited;
    public int n;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        n = board.length;
        visited = new boolean[n][n][n][n];
        visited[0][0][0][1] = true;
        Queue<index> queue = new LinkedList<>();
        queue.add(new index(0,0,0,1,0));

        while(!queue.isEmpty()){
            index tmp = queue.poll();

            if(tmp.x2==n-1 && tmp.y2==n-1){
                answer = Math.min(answer, tmp.count);
                continue;
            }

            //left-right
            if(tmp.x1==tmp.x2){
                int x = tmp.x1;
                int left = Math.min(tmp.y1, tmp.y2);
                int right = Math.max(tmp.y1, tmp.y2);

                if(right+1<n && board[x][right+1]==0 && !visited[x][left+1][x][right+1]){
                    visited[x][left+1][x][right+1] = true;
                    queue.add(new index(x,left+1,x,right+1,tmp.count+1));
                }
                if(left-1>=0 && board[x][left-1]==0 && !visited[x][left-1][x][right-1]){
                    visited[x][left-1][x][right-1] = true;
                    queue.add(new index(x,left-1,x,right-1,tmp.count+1));
                }


                if(x-1>=0 && board[x-1][left]==0 && board[x-1][right]==0){
                    if(!visited[x-1][left][x][left]){
                        visited[x-1][left][x][left] = true;
                        queue.add(new index(x-1,left,x,left,tmp.count+1));
                    }
                    if(!visited[x-1][right][x][right]){
                        visited[x-1][right][x][right] = true;
                        queue.add(new index(x-1,right,x,right,tmp.count+1));
                    }
                    if(!visited[x-1][left][x-1][right]){
                        visited[x-1][left][x-1][right] = true;
                        queue.add(new index(x-1,left,x-1,right,tmp.count+1));
                    }
                }
                if(x+1<n && board[x+1][left]==0 && board[x+1][right]==0){
                    if(!visited[x][left][x+1][left]){
                        visited[x][left][x+1][left] = true;
                        queue.add(new index(x,left,x+1,left,tmp.count+1));
                    }
                    if(!visited[x][right][x+1][right]){
                        visited[x][right][x+1][right] = true;
                        queue.add(new index(x,right,x+1,right,tmp.count+1));
                    }
                    if(!visited[x+1][left][x+1][right]){
                        visited[x+1][left][x+1][right] = true;
                        queue.add(new index(x+1,left,x+1,right,tmp.count+1));
                    }
                }

            }

            //up-down
            else if(tmp.y1==tmp.y2){
                int y = tmp.y1;
                int up = Math.min(tmp.x1, tmp.x2);
                int down = Math.max(tmp.x1, tmp.x2);

                if(down+1<n && board[down+1][y]==0 && !visited[up+1][y][down+1][y]){
                    visited[up+1][y][down+1][y] = true;
                    queue.add(new index(up+1,y,down+1,y,tmp.count+1));
                }
                if(up-1>=0 && board[up-1][y]==0 && !visited[up-1][y][down-1][y]){
                    visited[up-1][y][down-1][y] = true;
                    queue.add(new index(up-1,y,down-1,y,tmp.count+1));
                }


                if(y-1>=0 && board[up][y-1]==0 && board[down][y-1]==0){
                    if(!visited[up][y-1][up][y]){
                        visited[up][y-1][up][y] = true;
                        queue.add(new index(up,y-1,up,y,tmp.count+1));
                    }
                    if(!visited[down][y-1][down][y]){
                        visited[down][y-1][down][y] = true;
                        queue.add(new index(down,y-1,down,y,tmp.count+1));
                    }
                    if(!visited[up][y-1][down][y-1]){
                        visited[up][y-1][down][y-1] = true;
                        queue.add(new index(up,y-1,down,y-1,tmp.count+1));
                    }
                }
                if(y+1<n && board[up][y+1]==0 && board[down][y+1]==0){
                    if(!visited[up][y][up][y+1]){
                        visited[up][y][up][y+1] = true;
                        queue.add(new index(up,y,up,y+1,tmp.count+1));
                    }
                    if(!visited[down][y][down][y+1]){
                        visited[down][y][down][y+1] = true;
                        queue.add(new index(down,y,down,y+1,tmp.count+1));
                    }
                    if(!visited[up][y+1][down][y+1]){
                        visited[up][y+1][down][y+1] = true;
                        queue.add(new index(up,y+1,down,y+1,tmp.count+1));
                    }
                }
            }

        }
        return answer;
    }
    public class index{
        int x1;
        int y1;
        int x2;
        int y2;
        int count;
        public index(int x1, int y1, int x2, int y2, int count){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }
}