import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj1963 {
    public static boolean[] sosu = new boolean[10000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Arrays.fill(sosu, true);
        for(int i=0; i<1000; i++){
            sosu[i] = false;
        }
        for(int i=2; i<Math.sqrt(10000); i++){
            for(int j=i+i; j<10000; j+=i){
                sosu[j] = false;
            }
        }

        for(int t=0; t<T; t++){
            String[] input = br.readLine().split(" ");
            String A = input[0];
            String B = input[1];

            Queue<index> queue = new LinkedList<>();
            queue.add(new index(A, 0));
            boolean[] visited = new boolean[10000];
            boolean find = false;

            while(!queue.isEmpty()){
                index tmp = queue.poll();
                if(tmp.num.equals(B)){
                    System.out.println(tmp.count);
                    find = true;
                    break;
                }
                for(int i=0; i<=3; i++){
                    for(char j='0'; j<='9'; j++){
                        StringBuilder sb = new StringBuilder(tmp.num);
                        sb.setCharAt(i, j);
                        int number = Integer.parseInt(sb.toString());
                        if(visited[number]) continue;
                        visited[number] = true;
                        if(sosu[number]) queue.add(new index(sb.toString(), tmp.count+1));
                    }
                }



            }
            if(!find) System.out.println("Impossible");
        }
    }
    public static class index{
        String num;
        int count;
        public index(String num, int count){
            this.num = num;
            this.count = count;
        }
    }
}
