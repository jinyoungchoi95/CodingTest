import java.util.HashSet;

class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int len = relation[0].length;
        HashSet<String> tmp = new HashSet<>();
        HashSet<Integer> bitrate = new HashSet<>();
        for(int bit=1; bit<(1<<len); bit++){
            tmp = new HashSet<>();
            for(int i=0; i<relation.length; i++){
                String data = "";
                for(int j=0; j<len; j++){
                    if((bit & (1<<j)) != 0){
                        data += relation[i][j] + ",";
                    }
                }
                tmp.add(data);
            }
            if(tmp.size() == relation.length){
                check(bitrate, bit);
            }
        }
        answer = bitrate.size();
        return answer;
    }
    public void check(HashSet<Integer> bitrate, int bit){
        for(int Key : bitrate){
            if((Key & bit)==Key){
                return;
            }
        }
        bitrate.add(bit);
    }
}