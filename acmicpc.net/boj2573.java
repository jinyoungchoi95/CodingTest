import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2573 {
    public static int N, M;
    public static int[][] array, visited, melt;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        N = Integer.parseInt(input1[0]);
        M = Integer.parseInt(input1[1]);
        array = new int[N][M];
        visited = new int[N][M];
        melt = new int[N][M];
        for(int i=0; i<N; i++){
            String[] input2 = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                array[i][j] = Integer.parseInt(input2[j]);
            }
        }
        int result = 0;
        while(true){
            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(array[i][j]!=0 && visited[i][j]==0){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            if(count>=2){
                System.out.println(result);
                break;
            }
            else if(count==0){
                System.out.println(0);
                break;
            }
            melting();
            result++;
        }

    }
    public static void dfs(int x, int y){
        visited[x][y] = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(array[nx][ny]==0){
                    melt[x][y]++;
                }
                if(array[nx][ny]!=0 && visited[nx][ny]==0){
                    dfs(nx, ny);
                }
            }
        }
    }
    public static void melting(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                array[i][j] -= melt[i][j];
                if(array[i][j]<0) array[i][j] = 0;
                melt[i][j] = 0;
                visited[i][j] = 0;
            }
        }
    }
}
