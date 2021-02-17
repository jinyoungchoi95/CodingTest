import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj13019 {
    public static Queue<Character> A = new LinkedList<>();
    public static Queue<Character> B = new LinkedList<>();
    public static int answer = 0;
    public static boolean check = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        checkAB(A,B);
        if(!check){
            System.out.println(-1);
            return;
        }
        answer = A.length();
        int index = B.length() - 1;
        for(int i=A.length()-1; i>=0; i--){
            if (A.charAt(i) == B.charAt(index)) {
                answer--;
                index--;
            }
        }
        if(answer==A.length()) System.out.println(-1);
        else System.out.println(answer);
    }
    public static void checkAB(String A, String B){
        char[] A_char = A.toCharArray();
        char[] B_char = B.toCharArray();
        Arrays.sort(A_char);
        Arrays.sort(B_char);
        for(int i=0; i<A_char.length; i++){
            if(A_char[i] != B_char[i]){
                check = false;
                return;
            }
        }
    }
}
