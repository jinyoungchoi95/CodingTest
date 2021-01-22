import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    public int solution(String word, String[] pages) {
        int answer = 0;
        HashMap<String, Integer> hashmap = new HashMap<>();
        ArrayList<Page> list = new ArrayList<>();

        word = word.toLowerCase();
        for(int i=0; i<pages.length; i++){
            String s = pages[i].toLowerCase();
            int left = 0;
            int right = 0;
            int mid = 0;
            while(mid<=left){
                left = s.indexOf("<meta", left+1);
                right = s.indexOf(">", left);
                mid = s.lastIndexOf("https://", right);
            }
            right = s.indexOf("\"", mid);
            String url = s.substring(mid, right);
            hashmap.put(url, i);

            double basic = 0;
            int start = s.indexOf("<body>");
            while(true){
                start = s.indexOf(word, start+1);
                if(start<0) break;
                if(check_letter(s.charAt(start-1)) && check_letter(s.charAt(start+word.length()))){
                    basic++;
                }
            }
            double link = 0;
            start = s.indexOf("<body>");
            while(true){
                start = s.indexOf("<a href", start+1);
                if(start<0) break;
                link++;
            }
            list.add(new Page(i, basic, link, basic));
        }
        for(int i=0; i<pages.length; i++){
            String s = pages[i].toLowerCase();
            int start = s.indexOf("<body>");
            int end = 0;
            while(true){
                start = s.indexOf("<a href", start+1);
                if(start<0) break;
                start = s.indexOf("https://", start);
                end = s.indexOf("\"", start);
                String url = s.substring(start, end);
                if(hashmap.containsKey(url)){
                    int index = hashmap.get(url);
                    list.get(index).score += list.get(i).basic / list.get(i).link;
                }
            }
        }
        Collections.sort(list, new Comparator<Page>(){
            public int compare(Page o1, Page o2){
                if(o1.score==o2.score){
                    return o1.index-o2.index;
                }
                else if(o1.score<o2.score){
                    return 1;
                }
                else return -1;
            }
        });
        answer = list.get(0).index;
        return answer;
    }
    public boolean check_letter(char c){
        if('a'<=c && c<='z') return false;
        return true;
    }
    public class Page{
        int index;
        double basic;
        double link;
        double score;
        public Page(int index, double basic, double link, double score){
            this.index = index;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }
    }
}