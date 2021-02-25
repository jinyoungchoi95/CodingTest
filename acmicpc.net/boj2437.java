import java.io.*;
import java.util.*;

public class boj2437 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] chu = new int[N];
        for(int i=0; i<N; i++){
            chu[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(chu);
        int min = 1;
        for(int i=0; i<N; i++){
            if(min<chu[i]) break;
            min += chu[i];
        }
        System.out.println(min);
    }
}