import java.util.*;

class Solution {
    public Queue<Index> queue = new ArrayDeque<>();
    public int[] dx = {0, 0, -1, 1};
    public int[] dy = {-1, 1, 0, 0};
    public boolean[][] visited = new boolean[5][5];
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        for(int testCase=0; testCase<places.length; testCase++){
            queue = new ArrayDeque<>();
            visited = new boolean[5][5];
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++){
                    if(places[testCase][i].charAt(j)=='P') {
                        queue.add(new Index(i, j, 0));
                        visited[i][j] = true;
                    }
                }
            }
            while(!queue.isEmpty()){
                Index now = queue.poll();




                if(now.count==1) continue;

                for(int i=0; i<4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if(nx<0 || ny<0 || nx>=5 || ny>=5) {
                        continue;
                    }

                    if(places[testCase][nx].charAt(ny) == 'X') continue;
                    if(places[testCase][nx].charAt(ny) == 'P') {
                        answer[testCase] = 0;
                        break;
                    }

                    visited[nx][ny] = true;
                    queue.add(new Index(nx,ny,now.count+1));
                }
            }
        }


        return answer;
    }
    public class Index {
        int x;
        int y;
        int count;
        public Index(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}