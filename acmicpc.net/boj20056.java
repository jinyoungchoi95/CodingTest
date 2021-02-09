import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj20056 {
    public static int N, M, K;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static LinkedList<fireboll> map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);
        K = Integer.parseInt(input1[2]);
        int r,c,m,s,d;


        map = new LinkedList[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = new LinkedList<>();
            }
        }
        for(int i=0; i<M; i++){
            String[] input2 = br.readLine().split(" ");
            r = Integer.parseInt(input2[0])-1;
            c = Integer.parseInt(input2[1])-1;
            m = Integer.parseInt(input2[2]);
            s = Integer.parseInt(input2[3]);
            d = Integer.parseInt(input2[4]);
            map[r][c].add(new fireboll(m,s,d));
        }

        for(int i=0; i<K; i++){
            move_fire();
            split_fire();
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!map[i][j].isEmpty()){
                    for(fireboll fb : map[i][j]){
                        result += fb.m;
                    }
                }
            }
        }
        System.out.println(result);
    }
    public static class fireboll{
        int m,s,d;
        public fireboll(int m, int s, int d){
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void split_fire(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()>=2){
                    int sum_m = 0;
                    int sum_s = 0;
                    boolean odd = true;
                    boolean even = true;
                    for(fireboll fb : map[i][j]){
                        sum_m += fb.m;
                        sum_s += fb.s;
                        if(fb.d %2 == 0){
                            odd = false;
                        }
                        else{
                            even = false;
                        }
                    }
                    int new_m = sum_m/5;
                    int new_s = sum_s/map[i][j].size();
                    map[i][j].clear();
                    if(new_m>0){
                        for(int x=0; x<4; x++){
                            if(odd || even){
                                map[i][j].add(new fireboll(new_m, new_s, x*2));
                            }
                            else{
                                map[i][j].add(new fireboll(new_m, new_s, x*2+1));
                            }
                        }
                    }
                }

            }
        }
    }
    public static void move_fire(){
        LinkedList<fireboll> next[][] = new LinkedList[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                next[i][j] = new LinkedList<>();
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()>=1){
                    for(fireboll fb : map[i][j]){
                        int s = fb.s % N;
                        int x = dx[fb.d] * s + i;
                        int y = dy[fb.d] * s + j;
                        if(x>=N){
                            x -= N;
                        }
                        else if(x<0){
                            x += N;
                        }
                        if(y>=N){
                            y -= N;
                        }
                        else if(y<0){
                            y += N;
                        }
                        next[x][y].add(new fireboll(fb.m, fb.s, fb.d));
                    }
                }
            }
        }
        map = next;
    }
}