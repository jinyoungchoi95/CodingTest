import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class boj3190 {
    public static int N, K, L, d;
    public static int[][] board;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static Deque<index> snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        d = 0;
        board = new int[N+1][N+1];
        for(int i=0; i<K; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            board[x][y] = 1;
        }
        snake = new LinkedList<>();
        int x = 1;
        int y = 1;
        snake.add(new index(x, y));
        L = Integer.parseInt(br.readLine());
        int answer = 0;
        cmd[] command = new cmd[L+1];
        for(int i=0; i<L; i++){
            String[] input = br.readLine().split(" ");
            command[i] = new cmd(Integer.parseInt(input[0]), input[1].charAt(0));
        }
        command[L] = new cmd(Integer.MAX_VALUE, 'X');

        for(int i=0; i<=L; i++){
            int len = command[i].len;
            char direct = command[i].direct;
            while(answer<len){
                answer++;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
                    System.out.println(answer);
                    return;
                }
                index next = new index(nx, ny);
                if(!check_contain(next)){
                    System.out.println(answer);
                    return;
                }
                snake.addFirst(next);
                if (board[nx][ny] != 1) {
                    snake.removeLast();
                }
                else{
                    board[nx][ny] = 0;
                }
                x = nx;
                y = ny;
            }
            change_dir(direct);
        }
    }
    public static boolean check_contain(index next){
        int x = next.x;
        int y = next.y;
        ArrayList<index> tmp = new ArrayList<>(snake);
        for(int i=0; i<tmp.size(); i++){
            int x_i = tmp.get(i).x;
            int y_i = tmp.get(i).y;
            if(x==x_i && y==y_i){
                return false;
            }
        }
        return true;
    }
    public static void change_dir(char direct){
        if(direct=='L'){
            if(d==0){
                d=3;
            }
            else if(d==3){
                d=2;
            }
            else if(d==2){
                d=1;
            }
            else{
                d=0;
            }
        }
        else if(direct=='D'){
            if(d==0){
                d=1;
            }
            else if(d==1){
                d=2;
            }
            else if(d==2){
                d=3;
            }
            else{
                d=0;
            }
        }
    }
    public static class cmd{
        public int len;
        public char direct;
        public cmd(int len, char direct){
            this.len = len;
            this.direct = direct;
        }
    }
    public static class index{
        public int x;
        public int y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
