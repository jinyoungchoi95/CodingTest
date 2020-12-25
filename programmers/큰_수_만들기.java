class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int[] num = new int[number.length()];
        for(int i=0; i<num.length; i++){
            num[i] = Integer.parseInt(number.substring(i,i+1));
        }
        k = number.length() - k;
        int index = 0;
        int max_index = -1;
        int max = 0;

        while(k!=0){
            max_index++;
            max = num[max_index];
            index = max_index;
            while(max!=9 && index+k<=number.length()){
                if(max<num[index]){
                    max = num[index];
                    max_index = index;
                }
                index++;
            }

            answer += String.valueOf(max);
            k--;
        }

        return answer;
    }
}