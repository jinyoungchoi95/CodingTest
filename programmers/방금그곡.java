class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        m = m.replaceAll("C#", "c");
        m = m.replaceAll("D#", "d");
        m = m.replaceAll("F#", "f");
        m = m.replaceAll("G#", "g");
        m = m.replaceAll("A#", "a");

        int m_len = m.length();

        long max_time = Long.MIN_VALUE;

        for(int k=0; k<musicinfos.length; k++){
            String[] music = musicinfos[k].split(",");

            long time = cal_time(music[0], music[1]);

            music[3] = music[3].replaceAll("C#", "c");
            music[3] = music[3].replaceAll("D#", "d");
            music[3] = music[3].replaceAll("F#", "f");
            music[3] = music[3].replaceAll("G#", "g");
            music[3] = music[3].replaceAll("A#", "a");

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<time; i++){
                if(sb.toString().length()>=m_len*2 && sb.toString().length()>=music[3].length()*2){
                    break;
                }

                sb.append(music[3].charAt(i%music[3].length()));

                if(sb.toString().length()>=m_len && sb.toString().contains(m)){
                    if(time==max_time) break;
                    if(time>max_time){
                        max_time = time;
                        answer = music[2];
                    }
                    break;
                }
            }
        }

        return answer;
    }
    public long cal_time(String start, String end){
        String[] tmp = start.split(":");
        long hour_s = Long.parseLong(tmp[0]);
        long min_s = Long.parseLong(tmp[1]);

        tmp = end.split(":");
        long hour_e = Long.parseLong(tmp[0]);
        long min_e = Long.parseLong(tmp[1]);

        return (hour_e - hour_s)*60 + (min_e - min_s);
    }
}