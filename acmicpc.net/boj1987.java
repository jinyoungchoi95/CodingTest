import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1987 {
    public static int R, C;
    public static int result;
    public static int[][] board;
    public static boolean[] board_check;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        R = Integer.parseInt(input1[0]);
        C = Integer.parseInt(input1[1]);

        board = new int[R][C];
        board_check = new boolean[26];
        for(int i=0; i<R; i++){
            String input2 = br.readLine();
            for(int j=0; j<C; j++){
                board[i][j] = input2.charAt(j);
            }
        }
        board_check[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(result);


    }
    public static void dfs(int x, int y, int count){
        result  = Math.max(result,count);
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=R || ny>=C){
                continue;
            }
            int index = board[nx][ny] - 'A';
            if(!board_check[index]){
                board_check[index] = true;
                dfs(nx, ny, count+1);
                board_check[index] = false;
            }
        }
    }

}