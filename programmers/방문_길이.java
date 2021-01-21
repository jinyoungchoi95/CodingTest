import java.util.HashMap;

class Solution {
    public HashMap<Character, Integer> hashmap = new HashMap<>();
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    public boolean[][][] map = new boolean[11][11][4];
    public int solution(String dirs) {
        hashmap.put('U', 0);
        hashmap.put('R', 1);
        hashmap.put('D', 2);
        hashmap.put('L', 3);
        int answer = 0;

        int x = 5;
        int y = 5;

        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);

            int d = hashmap.get(c);
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx<0 || ny<0 || nx>10 || ny>10){
                continue;
            }
            int nd = (d+2)%4;

            if(!map[x][y][d]){
                map[x][y][d] = true;
                map[ny][ny][nd] = true;
                answer++;
            }

            x = nx;
            y = ny;
        }


        return answer;
    }
}