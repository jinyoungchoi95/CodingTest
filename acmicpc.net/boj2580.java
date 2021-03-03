import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj2580 {
    public static int[][] board = new int[9][9];
    public static ArrayList<index> list = new ArrayList<>();
    public static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<9; j++){
                board[i][j] = Integer.parseInt(input[j]);
                if(board[i][j]==0) list.add(new index(i,j));
            }
        }
        backtracking(0,0);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }
    public static void backtracking(int index, int count){
        if(check) return;

        if(list.size()==count){
            check = true;
            return;
        }

        index tmp = list.get(index);

        for(int i=1; i<=9; i++){
            if(!find(tmp.x, tmp.y, i)) continue;

            board[tmp.x][tmp.y] = i;
            backtracking(index+1,count+1);
            if(check) return;
            board[tmp.x][tmp.y] = 0;
        }
    }
    public static boolean find(int x, int y, int val) {
        for(int i=0; i<9; i++){
            if(board[x][i]==val || board[i][y]==val) return false;
        }

        for(int i=(x/3)*3; i<(x/3)*3+3; i++){
            for(int j=(y/3)*3; j<(y/3)*3+3; j++){
                if(board[i][j]==val) return false;
            }
        }
        return true;
    }
    public static class index{
        int x,y;
        public index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
