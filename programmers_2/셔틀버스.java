import java.util.*;

class Solution {
    public String answer = "";
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> time = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i=0; i<timetable.length; i++){
            time.add(calTime(timetable[i]));
        }


        int bus = 9*60;
        int ans = 0;

        while(n != 0) {
            n--;
            int able = m;
            int last = 0;

            while(!time.isEmpty()) {
                if(time.peek() <= bus && able != 0){
                    able--;
                    last = time.poll();
                } else break;
            }

            if(n>0){
                if(time.isEmpty()){
                    ans = bus + ((n+1)*t);
                }
                bus += t;
            } else {
                if(able > 0) ans = bus;
                else ans = last -1;
                break;
            }
        }
        answer = String.format("%02d", ans/60) + ":" + String.format("%02d", ans%60);
        return answer;
    }
    public int calTime(String input) {
        int result = 0;
        String[] time = input.split(":");
        result += Integer.parseInt(time[0]) * 60;
        result += Integer.parseInt(time[1]);
        return result;
    }
}