import java.util.*;

class Solution {
    public PriorityQueue<Wait> waiting = new PriorityQueue<>();
    public PriorityQueue<Run> running = new PriorityQueue<>();
    public int solution(int[][] jobs) {
        int answer = 0;
        int nowTime = 0;

        for(int i=0; i<jobs.length; i++){
            waiting.add(new Wait(jobs[i][0], jobs[i][1]));
        }

        while(!waiting.isEmpty() || !running.isEmpty()){


            if(!waiting.isEmpty()) {
                if(running.isEmpty()){
                    Wait now = waiting.poll();
                    if(nowTime < now.waitTime){
                        nowTime = now.waitTime;
                    }
                    running.add(new Run(now.waitTime, now.runTime));
                }
                while(!waiting.isEmpty() && nowTime >= waiting.peek().waitTime){
                    Wait plus = waiting.poll();
                    running.add(new Run(plus.waitTime, plus.runTime));
                }
            }



            Run run = running.poll();
            nowTime += run.runTime;
            answer += nowTime - run.waitTime;
        }
        answer /= jobs.length;
        return answer;
    }
    public class Wait implements Comparable<Wait> {
        int waitTime;
        int runTime;

        public Wait(int waitTime, int runTime) {
            this.waitTime = waitTime;
            this.runTime = runTime;
        }

        @Override
        public int compareTo(Wait o) {
            return this.waitTime - o.waitTime;
        }
    }
    public class Run implements Comparable<Run> {
        int waitTime;
        int runTime;

        public Run(int waitTime, int runTime) {
            this.waitTime = waitTime;
            this.runTime = runTime;
        }

        @Override
        public int compareTo(Run o) {
            return this.runTime - o.runTime;
        }
    }
}