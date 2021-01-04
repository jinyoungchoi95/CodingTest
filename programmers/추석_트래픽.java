import java.util.ArrayList;

class Solution {
    public int solution(String[] lines) {
        int answer = 1;

        ArrayList<index> list = new ArrayList<>();
        for(int k=0; k<lines.length; k++){
            String[] input = lines[k].split(" ");

            int time = (int) (1000*Double.parseDouble(input[2].substring(0,input[2].length()-1)));
            String[] clock = input[1].split(":");
            int hour = 1000*Integer.parseInt(clock[0]);
            int min = 1000*Integer.parseInt(clock[1]);
            int sec = (int) (1000*Double.parseDouble(clock[2]));
            sec += hour*60*60 + min*60;

            int start = sec-time+1;
            int end = sec;

            list.add(new index(start, end));
        }
        for(int i=0; i<list.size(); i++){
            index tmp = list.get(i);
            int result = 1;
            for(int j=0; j<list.size(); j++){
                if(i==j) continue;
                index tmp2 = list.get(j);

                if((tmp2.start<=tmp.end && tmp.end<=tmp2.end) || (tmp2.start<tmp.end+1000 && tmp.end+1<tmp2.end)){
                    result++;
                }
            }
            answer = Math.max(answer, result);

        }

        return answer;
    }
    public class index{
        int start;
        int end;
        public index(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}