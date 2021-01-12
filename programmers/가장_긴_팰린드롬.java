class Solution {
    public int solution(String s) {
        int answer = 1;
        int len = s.length();
        boolean[][] map = new boolean[s.length()][s.length()];
        for(int i=0; i<map.length; i++){
            map[i][i] = true;
        }
        for(int i=0; i<map.length-1; i++){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(c1==c2){
                map[i][i+1] = true;
                answer = 2;
            }
        }
        for(int k=3; k<=len; k++){
            for(int i=0; i<=len-k; i++){
                char c1 = s.charAt(i);
                char c2 = s.charAt(i+k-1);
                if(c1==c2 && map[i+1][i+k-2]){
                    map[i][i+k-1] = true;
                    answer = Math.max(answer, k);
                }
            }
        }


        return answer;
    }
}