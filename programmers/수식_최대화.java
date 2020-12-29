import java.util.ArrayList;

class Solution {
    public long answer;
    public ArrayList<Long> num = new ArrayList<>();
    public ArrayList<Character> sign = new ArrayList<>();
    public char[] sign_list = {'+', '-', '*'};
    public boolean[] visited = new boolean[3];
    public long solution(String expression) {
        answer = 0;

        int start = 0;
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                num.add(Long.parseLong(expression.substring(start,i)));
                sign.add(c);
                start = i+1;
            }
        }
        num.add(Long.parseLong(expression.substring(start)));
        ArrayList<Character> order = new ArrayList<>();
        dfs(0, order);
        return answer;
    }
    public void dfs(int index, ArrayList<Character> order){
        if(index==3){
            ArrayList<Long> num_tmp = new ArrayList<>(num);
            ArrayList<Character> sign_tmp = new ArrayList<>(sign);
            for(int k=0; k<3; k++){
                if(sign_tmp.isEmpty()){
                    break;
                }
                char c = order.get(k);

                boolean check = false;
                while(!sign_tmp.isEmpty()){
                    check = false;
                    for(int i=0; i<sign_tmp.size(); i++){
                        if(c==sign_tmp.get(i)){
                            sign_tmp.remove(i);
                            long a = num_tmp.get(i);
                            num_tmp.remove(i);
                            long b = num_tmp.get(i);
                            num_tmp.remove(i);
                            long ab = calculate(a, b, c);
                            num_tmp.add(i, ab);
                            check = true;
                            break;
                        }
                    }
                    if(!check) break;
                }
            }
            long result = Math.abs(num_tmp.get(0));
            answer = Math.max(answer, result);
            return;
        }


        for(int i=0; i<3; i++){
            if(!visited[i]){
                visited[i] = true;
                order.add(sign_list[i]);
                dfs(index+1, order);
                order.remove(index);
                visited[i] = false;
            }
        }
    }


    public long calculate(long a, long b, char c){
        if(c=='+'){
            return a+b;
        }
        else if(c=='-'){
            return a-b;
        }
        return a*b;
    }
}