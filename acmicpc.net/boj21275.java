import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj21275 {
    public static String A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = input[0];
        B = input[1];

        long a = getSystem('\u0000', A);
        long b = getSystem('\u0000', B);
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for(long i=a+1; i<=36; i++){
            for(long j=b+1; j<=36; j++){
                if(i==j) continue;
                long aNum = findOriginalNum(A, i);
                long bNum = findOriginalNum(B, j);
                if(aNum<0 || bNum<0) continue;
                if(aNum == bNum && aNum >= 0){
                    sb.append(aNum + " " + i + " " + j);
                    result++;
                }
            }
        }
//        System.out.println(sb.toString());
        if(result == 1) System.out.println(sb.toString());
        else if(result == 0) System.out.println("Impossible");
        else System.out.println("Multiple");

    }
    public static Long findOriginalNum(String num, Long system){
        Long result = getNum(num.charAt(num.length()-1));

        for(int i=num.length()-2; i>=0; i--){
            result += getNum(num.charAt(i)) * system;
            system *= system;
            if(result < 0) return -1L;
        }
        return result;
    }
    public static long getNum(char c){
        if(c <= '9') return (long) c - '0';
        return (long) c - 'a' + 10;
    }
    public static long getSystem(char a, String input){
        for(int i=0; i<input.length(); i++){
            if(a < input.charAt(i)) a = input.charAt(i);
        }
        long num = a - '0';
        if('a'<=a && a<='z') num = a - 'a' + 10;
        return num;
    }
    public static Long getNum(char c, int value, int index){
        long num = c - '0';
        if('a'<=c && c<='z') num = c - 'a' + 10;
        return num * (long) Math.pow(value, index);
    }
}
