import java.util.Stack;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int num = 1;
        p--;
        if(p==0){
            sb.append(0);
            t--;
        }
        while(t>0){
            int num_tmp = num;
            Stack<Integer> stack = new Stack<>();
            while(num_tmp!=0){
                stack.push(num_tmp%n);
                num_tmp/=n;
            }
            while(!stack.isEmpty()){
                index++;
                index%=m;
                int value = stack.pop();
                if(index==p){
                    if(value<10) sb.append(value);
                    else if(value==10) sb.append('A');
                    else if(value==11) sb.append('B');
                    else if(value==12) sb.append('C');
                    else if(value==13) sb.append('D');
                    else if(value==14) sb.append('E');
                    else if(value==15) sb.append('F');
                    t--;
                }
                if(t==0) break;
            }

            num++;
        }
        answer = sb.toString();

        return answer;
    }
}