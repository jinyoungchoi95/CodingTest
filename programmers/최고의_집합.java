class Solution {
    public int[] solution(int n, int s) {
        if(n>s){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[n];
        if(s%n==0){
            for(int i=0; i<n; i++){
                answer[i] = s/n;
            }
        }
        else{
            int r = s%n;
            int index = n-r;
            for(int i=0; i<index; i++){
                answer[i] = s/n;
            }
            for(int i=index; i<n; i++){
                answer[i] = s/n + 1;
            }
        }

        return answer;
    }
}