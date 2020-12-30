import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public char[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            ArrayList<index> list = new ArrayList<>();
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(map[i][j] != '0' && find(i,j)){
                        list.add(new index(i,j));
                    }
                }
            }
            if(list.isEmpty()){
                break;
            }

            for(int i=0; i<list.size(); i++){
                index tmp = list.get(i);
                if(map[tmp.x][tmp.y]!='0'){
                    answer++;
                    map[tmp.x][tmp.y] = '0';
                }
                if(map[tmp.x+1][tmp.y]!='0'){
                    answer++;
                    map[tmp.x+1][tmp.y] = '0';
                }
                if(map[tmp.x][tmp.y+1]!='0'){
                    answer++;
                    map[tmp.x][tmp.y+1] = '0';
                }
                if(map[tmp.x+1][tmp.y+1]!='0'){
                    answer++;
                    map[tmp.x+1][tmp.y+1] = '0';
                }
            }

            block_down(n, m);

        }


        return answer;
    }
    public boolean find(int i, int j){
        char c = map[i][j];
        if(c!=map[i+1][j] || c!=map[i][j+1] || c!=map[i+1][j+1]){
            return false;
        }
        return true;
    }
    public class index{
        int x;
        int y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void block_down(int n, int m){
        for(int j=0; j<n; j++){
            Queue<Character> queue = new LinkedList<>();
            for(int i=m-1; i>=0; i--){
                if(map[i][j]!='0'){
                    queue.add(map[i][j]);
                    map[i][j] = '0';
                }
            }
            if(queue.isEmpty()) continue;
            int i = m-1;
            while(!queue.isEmpty()){
                map[i--][j] = queue.poll();
            }
        }
        return;
    }
}