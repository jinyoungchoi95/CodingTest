import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj16236 {
    public static int N;
    public static int[][] map;
    public static int size = 2;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int start_x, start_y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 9){
                    start_x = i;
                    start_y = j;
                    map[i][j] = 0;
                }
            }
        }

        int answer = 0;
        int size_count = 0;
        while(true){
            ArrayList<index> fish = new ArrayList<>();
            Queue<index> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            visited[start_x][start_y] = true;
            queue.add(new index(start_x, start_y, 0));
            while(!queue.isEmpty()){
                index tmp = queue.poll();
                for(int i=0; i<4; i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx<0 || ny<0 || nx>=N || ny>=N){
                        continue;
                    }
                    if(map[nx][ny]>size){
                        continue;
                    }
                    if(!visited[nx][ny]){
                        visited[nx][ny] = true;
                        if(1<=map[nx][ny] && map[nx][ny]<size){
                            queue.offer(new index(nx,ny,tmp.move+1));
                            fish.add(new index(nx,ny, tmp.move+1));
                        }
                        else if(map[nx][ny]==0 || map[nx][ny]==size){
                            queue.offer(new index(nx,ny,tmp.move+1));
                        }
                    }
                }
            }
            if(fish.isEmpty()){
                System.out.println(answer);
                return;
            }

            index near = fish.get(0);
            for(int i=1; i<fish.size(); i++){
                if(near.move>fish.get(i).move){
                    near = fish.get(i);
                }
                else if(near.move == fish.get(i).move){
                    if(fish.get(i).x<near.x){
                        near = fish.get(i);
                    }
                    else if(fish.get(i).x==near.x){
                        if(fish.get(i).y<near.y){
                            near = fish.get(i);
                        }
                    }
                }
            }
            answer += near.move;
            size_count++;
            map[near.x][near.y] = 0;
            if(size_count==size){
                size_count = 0;
                size++;
            }
            start_x = near.x;
            start_y = near.y;
        }






    }
    public static class index{
        int x;
        int y;
        int move;
        public index(int x, int y, int move){
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }
}
