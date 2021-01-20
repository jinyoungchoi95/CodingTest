class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        int end = 0;
        int index = 0;

        while(start<=n){
            if(index==stations.length){
                end = n;
                int len = end-start+1;
                answer += len/(w+w+1);
                if(len%(w+w+1)!=0) answer++;
                break;
            }
            else if(start < stations[index]-w){
                end = stations[index]-w-1;
                int len = end-start+1;
                answer += len/(w+w+1);
                if(len%(w+w+1)!=0) answer++;
                start = stations[index]+w+1;
                index++;
            }
            else if(start >= stations[index]-w){
                start = stations[index]+w+1;
                index++;
            }
        }


        return answer;
    }
}