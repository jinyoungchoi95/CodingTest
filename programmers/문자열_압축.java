class Solution {
    public int solution(String s) {
        if(s.length()==1) return 1;
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=s.length()/2; i++){
            String before = "";
            String now = "";
            String result = "";
            int same = 1;
            for(int j=0; j<=s.length()/i; j++){
                int start = i * j;
                int end = start + i;
                if(end>s.length()) end = s.length();
                before = now;
                now = s.substring(start, end);
                if(before.equals(now)){
                    same++;
                }
                else{
                    if(same==1) result += before;
                    else result += String.valueOf(same) + before;
                    same = 1;
                }
            }
            if(same==1) result += now;
            else result += String.valueOf(same) + now;
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}