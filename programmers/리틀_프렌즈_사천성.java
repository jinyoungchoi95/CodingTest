import java.util.*;

class Solution {
    public char[][] map;
    public int m, n;
    public HashSet<Character> hashset = new HashSet<>();
    public int[] dx = {0, 0, 1};
    public int[] dy = {1, -1, 0};
    public String solution(int M, int N, String[] board) {
        String answer = "IMPOSSIBLE";
        m = M; n = N;
        map = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]!='.' && map[i][j]!='*'){
                    hashset.add(map[i][j]);
                }
            }
        }
        if(hashset.isEmpty()){
            answer = "";
            return answer;
        }
        ArrayList<Character> list = new ArrayList<>(hashset);
        StringBuilder sb = new StringBuilder();
        while(!list.isEmpty()){
            Collections.sort(list);
            boolean changed = false;
            for(int i=0; i<list.size(); i++){
                if(bfs(findxy(list.get(i)))){
                    sb.append(list.get(i));
                    list.remove(i);
                    changed = true;
                    break;
                }
            }
            if(!changed) break;
        }

        if(!list.isEmpty()){
            return answer;
        }
        answer = sb.toString();
        return answer;
    }
    public boolean bfs(int[] xy){
        int x = xy[0];
        int y = xy[1];
        Queue<index> queue = new LinkedList<>();
        for(int i=0; i<3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=m || ny>=n || map[nx][ny]=='*'){
                continue;
            }
            if(map[nx][ny]==map[x][y]){
                map[nx][ny] = map[x][y] = '.';
                return true;
            }
            if(map[nx][ny]=='.'){
                queue.add(new index(nx, ny, i, 0));
            }
        }
        while(!queue.isEmpty()){
            index tmp = queue.poll();
            for(int i=0; i<3; i++){
                if(tmp.c==1 && tmp.d!=i) continue;
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx==x&&ny==y) continue;
                if(nx<0 || ny<0 || nx>=m || ny>=n || map[nx][ny]=='*'){
                    continue;
                }
                if(map[nx][ny] == map[x][y]){
                    map[nx][ny] = map[x][y] = '.';
                    return true;
                }
                if(map[nx][ny]=='.'){
                    if(tmp.d==i){
                        queue.add(new index(nx, ny, i, tmp.c));
                    }
                    else{
                        queue.add(new index(nx, ny, i, tmp.c+1));
                    }
                }
            }
        }
        return false;
    }
    public int[] findxy(char c){
        int[] result = new int[2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==c){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    public class index{
        int x,y,d,c;
        public index(int x, int y, int d, int c){
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
}