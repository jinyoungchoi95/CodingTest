class Solution {
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target);

        return answer;
    }
    public void dfs(int[] numbers, int index, int target){
        if(numbers.length == index){
            int result = 0;
            for(int i=0; i<numbers.length; i++){
                result += numbers[i];
            }
            if(target==result){
                answer++;
            }
            return;
        }

        dfs(numbers, index+1, target);
        numbers[index] *= -1;
        dfs(numbers, index+1, target);
    }
}