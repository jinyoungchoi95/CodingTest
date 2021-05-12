import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1022 {
    public static int r1, c1, r2, c2;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r1 = Integer.parseInt(input[0]);
        c1 = Integer.parseInt(input[1]);
        r2 = Integer.parseInt(input[2]);
        c2 = Integer.parseInt(input[3]);
        map = new int[r2-r1+1][c2-c1+1];

        int x = 0;
        int y = 0;

        int num = 1;
        int d = 2;
        int count = 0;
        int limit = 1;
        int maxLen = 0;
        while(map[0][0]==0 || map[0][c2-c1]==0 || map[r2-r1][0]==0 || map[r2-r1][c2-c1]==0){

            if(x>=r1 && x<=r2 && y>=c1 && y<=c2){
                map[x-r1][y-c1] = num;
                maxLen = Math.max(maxLen, num);
            }
            count++;
            num++;
            x += dx[d];
            y += dy[d];
            if(count == limit) {
                d = (d+1) % 4;
                if(d%2==0) limit++;
                count = 0;
            }
        }
        maxLen = String.valueOf(maxLen).length();
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                print(map[i][j], maxLen);
                sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void print(int num, int maxLen){
        int len = num/10 + 1;
        int tmp = len;
        while(tmp<maxLen){
            sb.append(" ");
            tmp++;
        }
    }
}