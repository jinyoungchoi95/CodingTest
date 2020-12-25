class Solution {
    public int solution(String name) {
        int answer = 0;

        int[] alpha = new int[name.length()];
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            int right = (int) c - (int) 'A';
            int left = (int) 'Z' - (int) c + 1;
            alpha[i] = Math.min(right, left);
            answer += alpha[i];
        }

        int min = name.length() - 1;
        for(int i=0; i<name.length(); i++){
            int next = i+1;
            while(next<name.length() && name.charAt(next)=='A'){
                next++;
            }
            min = Math.min(min, 2*i + name.length() - next);
        }


        return answer+min;
    }
}