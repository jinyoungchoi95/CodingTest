class Solution {
    public int answer = 0 ;
    public int solution(String[] lines) {
        long[][] time = new long[lines.length][2];
        for(int i=0; i<lines.length; i++){
            String[] line = lines[i].split(" ");

            time[i][0] = calMiliSec(line[1]);
            time[i][1] = calTime(line[2]);
        }

        for(int i=0; i<time.length; i++){
            int count = 1;
            for(int j=0; j<time.length; j++){
                if(i==j) continue;
                if(check(time[j][0], time[j][1], time[i][0])) count++;
            }
            answer = Math.max(answer, count);
        }


        return answer;
    }
    public boolean check(long end, long time, long wantedStart) {
        long wantedEnd = wantedStart + 999;
        long start = end - time + 1;

        if(wantedStart <= start && start <= wantedEnd) return true;
        else if(wantedStart <= end && end <= wantedEnd) return true;
        else if(start <= wantedStart && wantedStart <= end && start <= wantedEnd && wantedEnd <= end) return true;

        return false;
    }

    public long calMiliSec(String input) {
        long result = 0;
        String[] times = input.split(":");
        result += Long.parseLong(times[0]) * 60 * 60 * 1000;
        result += Long.parseLong(times[1]) * 60 * 1000;
        times = times[2].split("[.]");
        result += Long.parseLong(times[0]) * 1000;
        result += Long.parseLong(times[1]);
        return result;
    }
    public long calTime(String input) {
        long result = 0;
        input = input.substring(0, input.length()-1);
        String[] times = input.split("[.]");
        result += Long.parseLong(times[0]) * 1000;
        if(times.length == 2) result += Long.parseLong(times[1]);
        return result;
    }
}