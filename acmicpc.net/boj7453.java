import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class boj7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] AB = new long[n*n];
        long[] CD = new long[n*n];
        long[][] array = new long[n][4];
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            array[i][0] = Integer.parseInt(input[0]);
            array[i][1] = Integer.parseInt(input[1]);
            array[i][2] = Integer.parseInt(input[2]);
            array[i][3] = Integer.parseInt(input[3]);
        }
        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                AB[index] = array[i][0] + array[j][1];
                CD[index] = array[i][2] + array[j][3];
                index++;
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        int ab_index = 0;
        int cd_index = CD.length - 1;
        long answer = 0;
        while(ab_index<AB.length && cd_index>=0){
            long AB_num = AB[ab_index];
            long CD_num = CD[cd_index];

            long AB_count = 0;
            long CD_count = 0;

            long total = AB_num + CD_num;
            if(total==0){
                while(ab_index<AB.length && AB[ab_index]==AB_num){
                    AB_count++;
                    ab_index++;
                }
                while(cd_index>=0 && CD[cd_index]==CD_num){
                    CD_count++;
                    cd_index--;
                }
                answer += AB_count * CD_count;
            }
            else if(total>0){
                cd_index--;
            }
            else{
                ab_index++;
            }
        }
        System.out.println(answer);







    }
    public static class abcd{
        public int a, b, c, d;
        public abcd(){

        }
        public abcd(int a, int b, int c, int d){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

    }
}