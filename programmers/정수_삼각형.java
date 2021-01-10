class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int h = triangle.length-1;
        int len = triangle[h-1].length;

        for(int i=h-1; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        answer = triangle[0][0];
        return answer;
    }
}