import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];
        int answer = 0;
        for(int i=0; i<n; i++){
            input = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==1) answer = 1;
            }
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(map[i][j]!=0){
                    map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i][j-1], map[i-1][j]))+1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        System.out.println(answer*answer);

    }
}