import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> gen = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(gen.isEmpty()){
                gen.put(genres[i], plays[i]);
            }
            else{
                int value = plays[i];
                if(gen.containsKey(genres[i])){
                    value += gen.get(genres[i]);
                }
                gen.put(genres[i], value);
            }
        }
        ArrayList<String> gen_list = new ArrayList<>(gen.keySet());
        Collections.sort(gen_list, new Comparator<String>(){
            public int compare(String o1, String o2){
                return gen.get(o2) - gen.get(o1);
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<gen_list.size(); i++){
            String genre = gen_list.get(i);
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            for(int j=0; j<plays.length; j++){
                if(genres[j].equals(genre)){
                    hashmap.put(j, plays[j]);
                }
            }
            ArrayList<Integer> tmp = new ArrayList<>(hashmap.keySet());
            Collections.sort(tmp, new Comparator<Integer>(){
                public int compare(Integer o1, Integer o2){
                    return hashmap.get(o2) - hashmap.get(o1);
                }
            });
            int count = 2;
            for(int k=0; k<tmp.size(); k++){
                list.add(tmp.get(k));
                count--;
                if(count==0) break;
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}