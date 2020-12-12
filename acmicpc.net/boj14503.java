import sun.security.util.math.intpoly.IntegerPolynomial;

import java.util.*;
import java.io.*;

public class boj14503 {
    public static int N,M,r,c,d;
    public static int[][] map;
    //public static int[] dx = {0, -1, 0, 1};
    //public static int[] dy = {-1, 0, 1, 0};

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx2 = {1, 0, -1, 0};
    public static int[] dy2 = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        d = Integer.parseInt(input[2]);

        map = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = 0;
        int count = 0;
        boolean back = true;
        while(back){
            if(map[r][c]==0){
                map[r][c] = 2;
                answer++;
            }
            while(true){
                if(count==4){
                    int nx = r - dx[d];
                    int ny = c - dy[d];
                    if(map[nx][ny]==1){
                        back = false;
                        break;
                    }
                    else{
                        r = nx;
                        c = ny;
                        count = 0;
                    }
                }
                d = (d+3)%4;
                int nx = r + dx[d];
                int ny = c + dy[d];
                if(map[nx][ny]==0){
                    count = 0;
                    r = nx;
                    c = ny;
                    break;
                }
                else{
                    count++;
                    continue;
                }
            }
        }
        System.out.println(answer);



    }





}
