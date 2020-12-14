import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj12100 {
    public static int N;
    public static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                max = Math.max(map[i][j], max);
            }
        }

        dfs(map, 0);
        System.out.println(max);

    }
    public static void dfs(int[][] map, int count){
        if (count==5){
            return;
        }

        dfs(up(map), count+1);
        dfs(down(map), count+1);
        dfs(left(map), count+1);
        dfs(right(map), count+1);
    }

    public static int[][] left(int[][] map){
        int[][] left = new int[N][N];
        Stack<Integer> stack = new Stack<>();
        boolean check = true;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]!=0){
                    if(stack.isEmpty()){
                        stack.add(map[i][j]);
                    }
                    else{
                        if(stack.peek() == map[i][j] && check){
                            stack.add(stack.pop() + map[i][j]);
                            check = false;
                            max = Math.max(max, stack.peek());
                            continue;
                        }
                        else{
                            stack.add(map[i][j]);
                        }
                    }
                    check = true;
                }
            }
            while(!stack.isEmpty()){
                int j = stack.size()-1;
                left[i][j] = stack.pop();
            }

        }
        return left;
    }

    public static int[][] right(int[][] map){
        int[][] right = new int[N][N];
        Stack<Integer> stack = new Stack<>();
        boolean check = true;
        for(int i=0; i<N; i++){
            for(int j=N-1; j>=0; j--){
                if(map[i][j]!=0){
                    if(stack.isEmpty()){
                        stack.add(map[i][j]);
                    }
                    else{
                        if(stack.peek() == map[i][j] && check){
                            stack.add(stack.pop() + map[i][j]);
                            check = false;
                            max = Math.max(max, stack.peek());
                            continue;
                        }
                        else{
                            stack.add(map[i][j]);
                        }
                    }
                    check = true;
                }
            }
            while(!stack.isEmpty()){
                int j = N - stack.size();
                right[i][j] = stack.pop();
            }

        }
        return right;
    }

    public static int[][] up(int[][] map){
        int[][] up = new int[N][N];
        Stack<Integer> stack = new Stack<>();
        boolean check = true;
        for(int j=0; j<N; j++){
            for(int i=0; i<N; i++){
                if(map[i][j]!=0){
                    if(stack.isEmpty()){
                        stack.add(map[i][j]);
                    }
                    else{
                        if(stack.peek() == map[i][j] && check){
                            stack.add(stack.pop() + map[i][j]);
                            check = false;
                            max = Math.max(max, stack.peek());
                            continue;
                        }
                        else{
                            stack.add(map[i][j]);
                        }
                    }
                    check = true;
                }
            }
            while(!stack.isEmpty()){
                int i = stack.size()-1;
                up[i][j] = stack.pop();
            }

        }
        return up;
    }

    public static int[][] down(int[][] map){
        int[][] down = new int[N][N];
        Stack<Integer> stack = new Stack<>();
        boolean check = true;
        for(int j=0; j<N; j++){
            for(int i=N-1; i>=0; i--){
                if(map[i][j]!=0){
                    if(stack.isEmpty()){
                        stack.add(map[i][j]);
                    }
                    else{
                        if(stack.peek() == map[i][j] && check){
                            stack.add(stack.pop() + map[i][j]);
                            check = false;
                            max = Math.max(max, stack.peek());
                            continue;
                        }
                        else{
                            stack.add(map[i][j]);
                        }
                    }
                    check = true;
                }
            }
            while(!stack.isEmpty()){
                int i = N - stack.size();
                down[i][j] = stack.pop();
            }

        }
        return down;
    }



}
