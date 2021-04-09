import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class boj5427 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test=0; test<T; test++){
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);

            map = new char[h][w];
            LinkedList<index> queue1 = new LinkedList<>();
            index start = new index(0,0,0,false);
            for(int i=0; i<h; i++){
                String input2 = br.readLine();
                for(int j=0; j<w; j++){
                    map[i][j] = input2.charAt(j);
                    if(map[i][j] == '*') queue1.add(new index(i, j, 0, false));
                    else if(map[i][j] == '@'){
                        map[i][j] = '.';
                        start = new index(i,j,0,true);
                    }
                }
            }
            queue1.addFirst(start);
            Queue<index> queue = new LinkedList<>(queue1);
            visited = new boolean[h][w];
            visited[start.x][start.y] = true;

            boolean check = true;
            while(!queue.isEmpty()){
                index tmp = queue.poll();

                if(tmp.sangun && (tmp.x==0 || tmp.y==0 || tmp.x==h-1 || tmp.y==w-1)){
                    System.out.println(tmp.count+1);
                    check = false;
                    break;
                }

                for(int i=0; i<4; i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx<0 || ny<0 || nx>=h || ny>=w) continue;

                    if(map[nx][ny] != '.') continue;

                    if(tmp.sangun){
                        queue.add(new index(nx, ny, tmp.count+1, true));
                    }
                    else{
                        map[nx][ny] = '*';
                        queue.add(new index(nx, ny, 0, false));
                    }
                }
            }
            if(check) System.out.println("IMPOSSIBLE");
        }
    }
    public static class index{
        int x;
        int y;
        int count;
        boolean sangun;

        public index(int x, int y, int count, boolean sangun) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.sangun = sangun;
        }
    }
}