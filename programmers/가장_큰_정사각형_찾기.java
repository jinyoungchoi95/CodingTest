import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int answer = 0;
    public int N, M;
    public int solution(int [][]board) {
        N = board.length;
        M = board[0].length;
        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                if(board[i][j]==1){
                    int up = board[i-1][j];
                    int left = board[i][j-1];
                    int up_left = board[i-1][j-1];
                    int min = Math.min(up_left, Math.min(up, left));
                    board[i][j] = min + 1;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                answer = Math.max(answer, board[i][j]);
            }
        }


        return answer * answer;
    }
}