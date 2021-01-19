import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int answer = 0;
    public ArrayList<String> answer_list = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {

        boolean[] visited = new boolean[user_id.length];
        ArrayList<String> list = new ArrayList<>();
        dfs(user_id, banned_id, visited, 0, list);
        return answer;
    }
    public void dfs(String[] user_id, String[] banned_id, boolean[] visited, int index, ArrayList<String> list){
        if(index==banned_id.length){
            StringBuilder sb = new StringBuilder();
            Collections.sort(list);
            for(int i=0; i<list.size(); i++){
                sb.append(list.get(i));
            }
            String input = sb.toString();
            if(!answer_list.contains(input)){
                answer_list.add(input);
                answer++;
            }
            return;
        }

        for(int i=0; i<user_id.length; i++){
            if(!visited[i] && check(user_id[i], banned_id[index])){
                visited[i] = true;
                ArrayList<String> tmp = new ArrayList<>(list);
                tmp.add(user_id[i]);
                dfs(user_id, banned_id, visited, index+1, tmp);
                visited[i] = false;
            }
        }
    }
    public boolean check(String user, String ban){
        if(user.length() != ban.length()){
            return false;
        }
        for(int i=0; i<user.length(); i++){
            if(user.charAt(i)!=ban.charAt(i) && ban.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
}