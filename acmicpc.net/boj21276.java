import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj21276 {
    public static int N, M;
    public static String[] peopleName;
    public static ArrayList<Integer>[] link;
    public static HashMap<String, Integer> peopleNameIndex = new HashMap<>();
    public static int[] parentCount;
    public static ArrayList<String>[] mySon;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        peopleName = new String[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        peopleName[0] = "";
        for(int i=1; i<=N; i++){
            peopleName[i] = st.nextToken();
        }
        Arrays.sort(peopleName);
        for(int i=1; i<=N; i++){
            peopleNameIndex.put(peopleName[i], i);
        }

        M = Integer.parseInt(br.readLine());
        link = new ArrayList[N+1];
        mySon = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            link[i] = new ArrayList<>();
            mySon[i] = new ArrayList<>();
        }
        parentCount = new int[N+1];
        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            int a = peopleNameIndex.get(input[0]);
            int b = peopleNameIndex.get(input[1]);
            link[a].add(b);
            parentCount[a]++;
        }

        PriorityQueue<Index> queue = new PriorityQueue<>();
        ArrayList<String> topAnswer = new ArrayList<>();
        for(int i=1; i<parentCount.length; i++){
            if(parentCount[i]==0){
                topAnswer.add(peopleName[i]);
                continue;
            }
            queue.add(new Index(i, parentCount[i]));
        }

        while(!queue.isEmpty()){
            Index tmp = queue.poll();

            int max = -1;
            int max_index = 0;
            for(int i=0; i<link[tmp.idx].size(); i++){
                int p = link[tmp.idx].get(i);
                if(max < parentCount[p]){
                    max = parentCount[p];
                    max_index = p;
                }
            }
            mySon[max_index].add(peopleName[tmp.idx]);
        }

        System.out.println(topAnswer.size());
        Collections.sort(topAnswer);
        for(int i=0; i<topAnswer.size(); i++){
            System.out.printf("%s ", topAnswer.get(i));
        }
        System.out.println();
        for(int i=1; i<=N; i++){
            Collections.sort(mySon[i]);
            System.out.printf("%s %d ", peopleName[i], mySon[i].size());
            for(int j=0; j<mySon[i].size(); j++){
                System.out.printf("%s ", mySon[i].get(j));
            }
            System.out.println();
        }
    }
    public static class Index implements Comparable<Index>{
        int idx;
        int count;
        public Index(int idx, int count){
            this.idx = idx;
            this.count = count;
        }

        @Override
        public int compareTo(Index o) {
            return o.count - this.count;
        }
    }
}
