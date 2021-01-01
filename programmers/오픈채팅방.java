import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> id = new HashMap<>();
        int len = record.length;
        for(int i=0; i<record.length; i++){
            String[] cmd = record[i].split(" ");
            if(cmd[0].equals("Enter")){
                id.put(cmd[1], cmd[2]);
            }
            else if(cmd[0].equals("Change")){
                id.put(cmd[1], cmd[2]);
                len--;
            }
        }

        StringBuilder sb = new StringBuilder();
        String[] answer = new String[len];
        int index = 0;
        for(int i=0; i<record.length; i++){
            sb = new StringBuilder();
            String[] cmd = record[i].split(" ");
            if(cmd[0].equals("Enter")){
                sb.append(id.get(cmd[1]));
                sb.append("님이 들어왔습니다.");
                answer[index++] = sb.toString();
            }
            else if(cmd[0].equals("Leave")){
                sb.append(id.get(cmd[1]));
                sb.append("님이 나갔습니다.");
                answer[index++] = sb.toString();
            }
        }

        return answer;
    }
}