import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class boj2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long T = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        Long[] A = new Long[n];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            A[i] = Long.parseLong(input[i]);
        }
        int m = Integer.parseInt(br.readLine());
        long[] B = new long[m];
        input = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            B[i] = Long.parseLong(input[i]);
        }

        ArrayList<Long> sumA = new ArrayList<>();
        ArrayList<Long> sumB = new ArrayList<>();
        for(int i=0; i<n; i++){
            long sum = A[i];
            sumA.add(sum);
            for(int j=i+1; j<n; j++){
                sum += A[j];
                sumA.add(sum);
            }
        }
        for(int i=0; i<m; i++){
            long sum = B[i];
            sumB.add(sum);
            for(int j=i+1; j<m; j++){
                sum += B[j];
                sumB.add(sum);
            }
        }

        sumA.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1-o2);
            }
        });
        sumB.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1-o2);
            }
        });

        int sizeA = sumA.size();
        int sizeB = sumB.size();

        int indexA = 0;
        int indexB = sizeB-1;
        long answer = 0;

        while(indexA < sizeA && indexB>=0) {
            long a = sumA.get(indexA);
            long b = sumB.get(indexB);
            long acount = 0;
            long bcount = 0;

            if (a + b == T) {
                while (indexA < sizeA && sumA.get(indexA) == a) {
                    indexA++;
                    acount++;
                }
                while (indexB >= 0 && sumB.get(indexB) == b) {
                    indexB--;
                    bcount++;
                }
                answer += acount * bcount;
            } else if (a + b > T) {
                indexB--;
            } else {
                indexA++;
            }
        }
        System.out.println(answer);
    }
}
