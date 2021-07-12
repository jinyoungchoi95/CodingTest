import java.util.*;

class Solution {
    public Map<String, Integer> hashmap = new HashMap<>();
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        addAlpha();

        StringBuilder tmp = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c>='0' && c<='9') answer.append(c);
            else {
                tmp.append(c);
                if(hashmap.containsKey(tmp.toString())){
                    answer.append(hashmap.get(tmp.toString()));
                    tmp = new StringBuilder();
                }
            }
        }


        return Integer.parseInt(answer.toString());
    }
    public void addAlpha() {
        hashmap.put("zero", 0);
        hashmap.put("one", 1);
        hashmap.put("two", 2);
        hashmap.put("three", 3);
        hashmap.put("four", 4);
        hashmap.put("five", 5);
        hashmap.put("six", 6);
        hashmap.put("seven", 7);
        hashmap.put("eight", 8);
        hashmap.put("nine", 9);
    }
}