import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10026 {
    //public static int[][] draw, draw2;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] draw = new int[N][N];
        int[][] draw2 = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++){
                if(input[j].equals("R")){
                    draw[i][j] = 1;
                    draw2[i][j] = 1;
                }
                else if(input[j].equals("G")){
                    draw[i][j] = 2;
                    draw2[i][j] = 1;
                }
                else{
                    draw[i][j] = 3;
                    draw2[i][j] = 2;
                }
            }
        }
        int result_1 = 0;
        int result_2 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(dfs(i,j,1, draw)){
                    result_1++;
                }
                else if(dfs(i,j,2,draw)){
                    result_1++;
                }
                else if(dfs(i,j,3,draw)){
                    result_1++;
                }

                if(dfs(i,j,1,draw2)){
                    result_2++;
                }
                else if(dfs(i,j,2,draw2)){
                    result_2++;
                }
            }
        }
        System.out.printf("%d %d", result_1, result_2);

    }
    public static boolean dfs(int i, int j, int num, int[][] array){
        if(i<0 || i>=N || j<0 || j>=N){
            return false;
        }
        if(array[i][j]==num){
            array[i][j] = 0;
            dfs(i+1, j, num, array);
            dfs(i-1, j, num, array);
            dfs(i, j+1, num, array);
            dfs(i, j-1, num, array);
            return true;
        }
        return false;
    }



}
