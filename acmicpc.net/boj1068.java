import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1068 {
    public static int N;
    public static Node[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];
        for(int i=0; i<N; i++){
            nodes[i] = new Node(-1, new ArrayList<>());
        }
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(input[i]);
            if(parent==-1) continue;
            nodes[parent].child.add(i);
            nodes[i].parent = parent;
        }

        int delete = Integer.parseInt(br.readLine());
        if(nodes[delete].parent!=-1) nodes[nodes[delete].parent].child.remove((Integer) delete);
        deleteNode(delete);


        int answer = 0;
        for(int i=0; i<N; i++){
            if(nodes[i].child.isEmpty() && !nodes[i].deleted) answer++;
        }
        System.out.println(answer);
    }
    public static void deleteNode(int index){
        nodes[index].deleted = true;
        if(nodes[index].child.isEmpty()) return;

        for(int i=0; i<nodes[index].child.size(); i++){
            int next = nodes[index].child.get(i);
            deleteNode(next);
        }
    }
    public static class Node {
        int parent;
        ArrayList<Integer> child;
        boolean deleted;

        public Node(int parent, ArrayList<Integer> child) {
            this.parent = parent;
            this.child = child;
            this.deleted = false;
        }
    }
}