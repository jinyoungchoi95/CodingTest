import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;

        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++){
            if(check(i, str1)){
                A.add(str1.substring(i,i+2).toUpperCase());
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            if(check(i, str2)){
                B.add(str2.substring(i,i+2).toUpperCase());
            }
        }

        ArrayList<String> mother = new ArrayList<>();
        ArrayList<String> B_tmp = new ArrayList<>(B);
        if(!A.isEmpty()){
            for(int i=0; i<A.size(); i++){
                if(B_tmp.contains(A.get(i))){
                    B_tmp.remove(A.get(i));
                }
                mother.add(A.get(i));
            }
        }
        if(!B.isEmpty()){
            for(int i=0; i<B_tmp.size(); i++){
                mother.add(B_tmp.get(i));
            }
        }
        if(mother.isEmpty()) return 65536;
        int bot = mother.size();

        int top = 0;
        B_tmp = new ArrayList<>(B);
        if(!A.isEmpty()){
            for(int i=0; i<A.size(); i++){
                if(B_tmp.contains(A.get(i))){
                    B_tmp.remove(A.get(i));
                    top++;
                }
            }
        }

        answer = (top*65536)/bot;

        return answer;
    }
    public boolean check(int i, String str){
        char c1 = str.charAt(i);
        char c2 = str.charAt(i+1);
        if(!(c1>='A' && c1<='Z') && !(c1>='a' && c1<='z')){
            return false;
        }
        if(!(c2>='A' && c2<='Z') && !(c2>='a' && c2<='z')){
            return false;
        }
        return true;
    }
}