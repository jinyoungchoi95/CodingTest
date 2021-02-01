import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj14658 {
    public static int N, M, L, K;
    public static index[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        L = Integer.parseInt(input[2]);
        K = Integer.parseInt(input[3]);
        map = new index[K];
        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            map[i] = new index(x,y);
        }
        int answer = 0;
        int count = 0;
        for(int i=0; i<K; i++){
            for(int j=0; j<K; j++){
                count = Math.max(count, cal_tram(i,j));
            }
        }
        answer = K - count;
        System.out.println(answer);
    }
    public static int cal_tram(int i, int j){
        int result = 0;
        for(int k=0; k<K; k++){
            if(map[i].x<=map[k].x && map[k].x<=map[i].x+L){
                if(map[j].y<=map[k].y && map[k].y<=map[j].y+L){
                    result++;
                }
            }
        }
        return result;
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
