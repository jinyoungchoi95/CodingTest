import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> hashset = new HashSet<>();
        for(int i=0; i<gems.length; i++){
            hashset.add(gems[i]);
        }
        int size = hashset.size();

        int min_start = 0;
        int min_end = 0;
        int min_len = Integer.MAX_VALUE;
        HashMap<String, Integer> hashmap = new HashMap<>();
        int start = 0;
        int end = 0;
        hashmap.put(gems[0], 1);
        while(true){
            if(size == hashmap.size()){
                int len = end - start+1;
                if(len<min_len){
                    min_start = start;
                    min_end = end;
                    min_len = len;
                }
                if(len==size) break;
            }

            int value = hashmap.get(gems[start]);
            if(value>=2){
                hashmap.put(gems[start++], value-1);
            }
            else if(value==1 && end==gems.length-1){
                break;
            }
            else{
                end++;
                if(!hashmap.containsKey(gems[end])){
                    hashmap.put(gems[end], 1);
                }
                else{
                    value = hashmap.get(gems[end]);
                    hashmap.put(gems[end], value+1);
                }
            }
        }



        answer[0] = min_start+1;
        answer[1] = min_end+1;
        return answer;
    }
}