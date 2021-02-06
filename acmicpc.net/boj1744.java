import java.io.*;
import java.util.*;

public class boj1744 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for(int i=0; i<N; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        int start_num = 0;
        int answer = 0;
        int left = 0;
        int right = 0;
        boolean zero = false;
        boolean one = false;
        for(int i=0; i<N; i++){
            if(array[i]<0) left++;
            else if(array[i]>1) right++;
            else if(array[i]==0) zero = true;
            else if(array[i]==1) answer++;
        }

        if(left%2==0){
            for(int i=0; i<left; i+=2){
                answer += array[i] * array[i+1];
            }
        }
        else if(left%2==1){
            for(int i=0; i<left-1; i+=2){
                answer += array[i] * array[i+1];
            }
            if(!zero) answer += array[left-1];
        }

        if(right%2==0){
            for(int i=N-1; i>=N-right; i-=2){
                answer += array[i] * array[i-1];
            }
        }
        else if(right%2==1){
            for(int i=N-1; i>N-right; i-=2){
                answer += array[i] * array[i-1];
            }
            answer += array[N-right];
        }
        System.out.println(answer);

    }

}