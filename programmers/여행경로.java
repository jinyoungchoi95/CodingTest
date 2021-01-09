class Solution {
    public String tmp = "";
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];

        dfs(tickets, visited, "", "", tickets.length);
        for(int i=0; i<answer.length; i++){
            answer[i] = tmp.substring(i*3, i*3+3);
        }

        return answer;
    }
    public void dfs(String[][] tickets, boolean[] visited, String last, String result, int ticket){
        if(ticket==0){
            if(tmp.equals("")){
                tmp = result;
            }
            else{
                if(tmp.compareTo(result)>0){
                    tmp = result;
                }
            }
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(last.equals("") && tickets[i][0].equals("ICN")){
                    dfs(tickets, visited, tickets[i][1], result+tickets[i][0]+tickets[i][1], ticket-1);
                }
                else if(last.equals(tickets[i][0])){
                    dfs(tickets, visited, tickets[i][1], result+tickets[i][1], ticket-1);
                }
                visited[i] = false;
            }
        }
    }
}