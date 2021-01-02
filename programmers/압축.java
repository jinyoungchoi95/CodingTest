import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public ArrayList<Integer> list = new ArrayList<>();
    public HashMap<String, Integer> hashmap = new HashMap<>();
    public int[] solution(String msg) {
        for(int i=0; i<26; i++){
            char c = (char) ((int)'A' + i);
            hashmap.put(String.valueOf(c), i+1);
        }

        int index = 27;
        int tmp = 0;

        StringBuilder sb;
        int j = 0;
        boolean out = false;
        for(int i=0; i<msg.length(); i++){
            if(out) break;

            sb = new StringBuilder();

            int num = 0;
            i = j ;
            for(j=i; j<msg.length(); j++){
                sb.append(msg.charAt(j));
                if(j==msg.length()-1 && hashmap.containsKey(sb.toString())){
                    num = hashmap.get(sb.toString());
                    list.add(num);
                    out = true;
                    break;
                }

                if(hashmap.containsKey(sb.toString())){
                    num = hashmap.get(sb.toString());
                }
                else{
                    hashmap.put(sb.toString(), index++);
                    list.add(num);
                    break;
                }
            }
        }


        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}