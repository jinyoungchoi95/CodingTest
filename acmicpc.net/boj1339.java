import java.io.*;
import java.util.*;

public class boj1339 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] alphbat = new char[10];
        Arrays.fill(alphbat, '0');
        long[] weight = new long[10];

        for(int i=0; i<N; i++){
            String input = br.readLine();
            long w = 1;
            for(int j=input.length()-1; j>=0; j--){
                char alphbat_chr = input.charAt(j);
                for(int z=0; z<10; z++){
                    if(alphbat[z] == alphbat_chr){
                        weight[z] += w;
                        break;
                    }
                    else if(alphbat[z]=='0'){
                        alphbat[z] = alphbat_chr;
                        weight[z] += w;
                        break;
                    }
                }
                w *= 10;
            }
        }

        Arrays.sort(weight);
        long answer = 0;
        for(int i=0; i<weight.length; i++){
            answer += (long) i * weight[i];
        }
        System.out.println(answer);
    }
}