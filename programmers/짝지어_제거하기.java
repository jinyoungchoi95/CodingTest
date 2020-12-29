import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        char[] array = new char[s.length()];
        for(int i=0; i<s.length(); i++){
            array[i] = s.charAt(i);
        }

        for(int i=0; i<array.length; i++){
            if(!stack.isEmpty() && stack.peek()==array[i]){
                stack.pop();
            }
            else{
                stack.push(array[i]);
            }
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}