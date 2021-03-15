import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11404 {
    public static int n, m;
    public static int[][] map;
    public static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for(int M=0; M<m; M++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], cost);
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                if(map[i][j] == INF) System.out.printf("%d ", 0);
                else System.out.printf("%d ", map[i][j]);
            }
            System.out.println();
        }

    }
}
