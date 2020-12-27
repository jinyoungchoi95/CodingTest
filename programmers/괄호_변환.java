import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int len;
    public String solution(String p) {
        String answer = "";
        if(answer.equals(p)){
            return answer;
        }
        len = p.length();

        answer = make(p);


        return answer;
    }
    public String make(String p){
        String result = "";
        if(p.equals(result)) return result;

        int left = 0;
        int right = 0;
        String u = "";
        if(p.charAt(0) == '('){
            left++;
            u += "(";
        }
        else{
            right++;
            u += ")";
        }
        for(int i=1; i<p.length(); i++){
            if(p.charAt(i) == '('){
                left++;
                u += "(";
            }
            else{
                right++;
                u += ")";
            }
            if(left==right){
                if(check(u)){
                    result +=u;
                }
                else{
                    String v = p.substring(i+1);
                    result += "(" + make(v) + ")";
                    p = p.substring(0,i+1);
                    p += reverse(u.substring(1,u.length()-1));
                }
                u = "";
            }
        }
        return result;

    }
    public boolean check(String s){
        int tmp = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                tmp++;
            }
            else{
                tmp--;
            }
            if(tmp<0) return false;
        }
        return true;
    }
    public String reverse(String u){
        String result = "";
        if(u.equals(result)) return result;
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i)=='('){
                result += ")";
            }
            else{
                result += "(";
            }
        }
        return result;
    }
}