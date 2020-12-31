import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cities.length==0) return answer;
        if(cacheSize==0) return cities.length*5;

        ArrayList<String> cache = new ArrayList<>();
        cities[0] = cities[0].toUpperCase();
        cache.add(cities[0]);
        answer += 5;

        for(int i=1; i<cities.length; i++){
            cities[i] = cities[i].toUpperCase();
            if(cache.size()<cacheSize){
                if(cache.contains(cities[i])){
                    answer+=1;
                    cache.remove(cities[i]);
                    cache.add(cities[i]);
                }
                else{
                    answer+=5;
                    cache.add(cities[i]);
                }
            }
            else{
                if(cache.contains(cities[i])){
                    answer+=1;
                    cache.remove(cities[i]);
                    cache.add(cities[i]);
                }
                else{
                    answer+=5;
                    cache.remove(0);
                    cache.add(cities[i]);
                }
            }

        }

        return answer;
    }
}