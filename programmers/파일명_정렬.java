import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            public int compare(String o1, String o2){
                String str1 = o1.split("[0-9]")[0];
                String str2 = o2.split("[0-9]")[0];

                int result = str1.toLowerCase().compareTo(str2.toLowerCase());
                if(result==0){
                    result = compare_int(o1, str1) - compare_int(o2, str2);
                }
                return result;
            }
        });


        return files;
    }
    public int compare_int(String o1, String str1){
        StringBuilder sb = new StringBuilder();
        o1 = o1.replaceAll(str1, "");
        for(int i=0; i<o1.length(); i++){
            char c = o1.charAt(i);
            if( c>='0' && c<='9' && sb.toString().length()<5){
                sb.append(c);
            }
            else{
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}