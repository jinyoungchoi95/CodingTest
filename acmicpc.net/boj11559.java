import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class boj11559 {
    public static char[][] map = new char[12][6];
    public static boolean[][] visited = new boolean[12][6];
    public static boolean check;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<12; i++){
            String input = br.readLine();
            for(int j=0; j<6; j++){
                map[i][j] = input.charAt(j);
            }
        }

        check = true;
        int answer = 0;
        while(check){
            check = false;
            visited = new boolean[12][6];
            for(int i=11; i>=0; i--){
                for(int j=0; j<6; j++){
                    if(map[i][j] != '.' && !visited[i][j]){
                        bfs(i,j);
                    }
                }
            }
            if(check){
                answer++;
                down_block();
            }
        }
        System.out.println(answer);
    }
    public static void down_block(){
        for(int j=0; j<6; j++){
            Deque<Character> deque = new LinkedList<>();
            for(int i=0; i<12; i++){
                if(map[i][j]=='.'){
                    deque.addLast('.');
                }
                else{
                    deque.addFirst(map[i][j]);
                }
            }
            for(int i=11; i>=0; i--){
                map[i][j] = deque.pollFirst();
            }
        }
    }
    public static void bfs(int x, int y){
        Queue<index> queue = new LinkedList<>();
        ArrayList<index> block = new ArrayList<>();
        queue.add(new index(x,y));
        block.add(new index(x,y));
        char value = map[x][y];
        visited[x][y] = true;
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx<0 || ny<0 || nx>= 12 || ny>=6){
                    continue;
                }
                if(!visited[nx][ny] && map[nx][ny]==map[tmp.x][tmp.y]){
                    visited[nx][ny] = true;
                    queue.add(new index(nx,ny));
                    block.add(new index(nx,ny));
                }
            }
        }
        if(block.size()>=4){
            check = true;
            for(int i=0; i<block.size(); i++){
                index tmp = block.get(i);
                map[tmp.x][tmp.y] = '.';
            }
        }
    }
    public static class index{
        int x;
        int y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
