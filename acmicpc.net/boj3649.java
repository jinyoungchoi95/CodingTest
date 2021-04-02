import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class boj3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;

            int n = Integer.parseInt(br.readLine());
            int[] array = new int[n];
            for(int i=0; i<array.length; i++){
                array[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(array);
            boolean check = false;
            int start = 0;
            int end = n-1;

            while(start < end) {
                int sum = array[start] + array[end];

                if(x == sum){
                    check = true;
                    break;
                }

                if(sum < x) {
                    start ++;
                }
                else{
                    end --;
                }
            }
            if(!check) System.out.println("danger");
            else System.out.println("yes " + array[start] + " " + array[end]);
        }
    }
}
