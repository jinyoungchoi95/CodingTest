import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable, new Comparator<String>(){
            public int compare(String o1, String o2){
                int o1_hour = Integer.parseInt(o1.split(":")[0]);
                int o1_min = Integer.parseInt(o1.split(":")[1]);
                int o2_hour = Integer.parseInt(o2.split(":")[0]);
                int o2_min = Integer.parseInt(o2.split(":")[1]);
                if(o1_hour==o2_hour){
                    return o1_min - o2_min;
                }
                return o1_hour - o2_hour;
            }
        });
        Queue<Time> queue = new LinkedList<>();
        for(int i=0; i<timetable.length; i++){
            queue.add(new Time(Integer.parseInt(timetable[i].split(":")[0]), Integer.parseInt(timetable[i].split(":")[1])));
        }
        Time bus = new Time(9,0);
        Time corn = new Time(9,0);
        for(int i=1; i<=n; i++){
            int person = 0;
            for(int j=0; j<m; j++){
                if(!queue.isEmpty()){
                    Time tmp = queue.peek();

                    if(tmp.hour<bus.hour || (tmp.hour==bus.hour && tmp.min <= bus.min)){
                        corn = queue.poll();
                        person++;
                    }
                }
                if(i==n && person==m){
                    corn = new Time(corn.hour, corn.min-1);
                }
                if(i==n && person<m){
                    corn = new Time(bus.hour, bus.min);
                }
            }
            bus = new Time(bus.hour, bus.min+t);
        }
        if(corn.hour<10){
            answer += "0";
        }
        answer += String.valueOf(corn.hour) + ":";
        if(corn.min<10){
            answer += "0";
        }
        answer += String.valueOf(corn.min);

        return answer;
    }
    public class Time{
        int hour;
        int min;
        public Time(int hour, int min){
            if(min<0){
                min+=60;
                hour--;
            }
            else if(min>=60){
                min-=60;
                hour++;
            }
            this.hour = hour;
            this.min = min;
        }
    }
}