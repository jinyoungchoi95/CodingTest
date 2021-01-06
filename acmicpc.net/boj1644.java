import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[N+1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i*i<=N; i++){
            if(!check[i]){
                for(int j=i*i; j<=N; j+=i){
                    check[j] = true;
                }
            }
        }
        for(int i=2; i<=N; i++){
            if(!check[i]) list.add(i);
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while(true){
            if(sum>=N){
                sum -= list.get(start++);
            }
            else if(end==list.size()){
                break;
            }
            else{
                sum += list.get(end++);
            }

            if(sum==N){
                count++;
            }
        }
        System.out.println(count);
    }
}
