import java.util.*;
class Solution {
    public HashMap<Character, Integer>  hashmap = new HashMap<>();
    public int solution(String s) {
        int answer = 0;
        hashmap.put('[', 0);
        hashmap.put('{', 1);
        hashmap.put('(', 2);
        hashmap.put(']', 3);
        hashmap.put('}', 4);
        hashmap.put(')', 5);

        int size = s.length();

        for(int i=0; i<size; i++){
            s = s.substring(1) + s.substring(0,1);
            Stack<Integer> stack = new Stack<>();
            for(int j=0; j<s.length(); j++){
                char now = s.charAt(j);
                int num = hashmap.get(now);
                if(num < 3){
                    stack.add(num);
                }
                else{
                    if(stack.isEmpty() || stack.peek()!=num-3) stack.add(num);
                    else stack.pop();
                }
            }
            if(stack.isEmpty()) answer++;
        }

        return answer;
    }
}