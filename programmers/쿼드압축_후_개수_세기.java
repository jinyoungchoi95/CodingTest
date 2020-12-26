class Solution {
    public int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        dfs(arr, 0, arr.length-1, 0, arr.length-1);


        return answer;
    }
    public void dfs(int[][] arr, int x1, int x2, int y1, int y2){
        if(x1==x2 && y1==y2){
            answer[arr[x1][y1]]++;
            return;
        }

        if(check(arr, x1, x2, y1, y2)){
            answer[arr[x1][y1]]++;
            return;
        }
        else{
            int x_mid = (x1+x2)/2;
            int y_mid = (y1+y2)/2;
            dfs(arr, x1, x_mid, y1, y_mid);
            dfs(arr, x1, x_mid, y_mid+1, y2);
            dfs(arr, x_mid+1, x2, y1, y_mid);
            dfs(arr, x_mid+1, x2, y_mid+1, y2);
        }

    }
    public boolean check(int[][] arr, int x1, int x2, int y1, int y2){
        int[] answer = new int[2];
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                answer[arr[i][j]]++;
            }
        }
        if(answer[0]==0 || answer[1]==0) return true;
        return false;
    }
}