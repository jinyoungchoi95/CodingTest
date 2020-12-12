import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class boj15686 {
    public static int N, M;
    public static ArrayList<index> house, chicken;
    public static Stack<index> selected = new Stack<>();
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[][] city = new int[N+1][N+1];

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                city[i][j] = Integer.parseInt(input[j-1]);
                if(city[i][j]==1){
                    house.add(new index(i,j));
                }
                else if(city[i][j]==2){
                    chicken.add(new index(i,j));
                }
            }
        }
        dfs(0,0);
        System.out.println(answer);


    }
    public static void dfs(int start, int depth){
        if(depth == M){
            calculate();
            return;
        }
        for(int i=start; i<chicken.size(); i++){
            selected.push(chicken.get(i));
            dfs(i+1, depth+1);
            selected.pop();
        }
    }
    public static void calculate(){
        int sum = 0;
        for(int i=0; i<house.size(); i++){
            int min = Integer.MAX_VALUE;
            for(int j=0; j<selected.size(); j++){
                int distance = cal_distance(house.get(i), selected.get(j));
                min = Math.min(distance, min);
            }
            sum += min;
        }
        answer = Math.min(answer, sum);
    }
    public static int cal_distance(index a, index b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
    public static class index{
        public int x;
        public int y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

