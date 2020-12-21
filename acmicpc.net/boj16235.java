import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class boj16235 {
    public static int N, M, K;
    public static int[][] map;
    public static int[][] feed;
    public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static ArrayList<index> tree;
    public static ArrayList<index> die;
    public static ArrayList<index> grow;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        map = new int[N+1][N+1];
        feed = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                feed[i][j] = Integer.parseInt(input[j-1]);
                map[i][j] = 5;
            }
        }

        tree = new ArrayList<>();
        for(int m=0; m<M; m++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);
            tree.add(new index(x,y,z));
        }

        for(int k=0; k<K; k++){
            Collections.sort(tree, new Comparator<index>() {
                @Override
                public int compare(index o1, index o2) {
                    return o1.year - o2.year;
                }
            });
            spring();
            summer();
            fall();
            winter();
            tree.clear();
            die.clear();
            tree = new ArrayList<>(grow);
            grow.clear();
        }
        System.out.println(tree.size());
    }
    public static void spring(){
        if(tree.isEmpty()){
            return;
        }
        die = new ArrayList<>();
        grow = new ArrayList<>();
        for(int i=0; i<tree.size(); i++){
            index tmp = tree.get(i);
            if(map[tmp.x][tmp.y] >= tmp.year){
                grow.add(new index(tmp.x, tmp.y, tmp.year+1));
                map[tmp.x][tmp.y] -= tmp.year;
            }
            else{
                die.add(new index(tmp.x, tmp.y, tmp.year));
            }
        }
    }
    public static void summer(){
        if(die.isEmpty()){
            return;
        }
        for(int i=0; i<die.size(); i++){
            index tmp = die.get(i);
            map[tmp.x][tmp.y] += tmp.year/2;
        }
    }
    public static void fall(){
        if(grow.isEmpty()){
            return;
        }
        for(int i=0; i<grow.size(); i++){
            index tmp = grow.get(i);
            if(tmp.year%5==0){
                for(int k=0; k<dx.length; k++){
                    int nx = tmp.x + dx[k];
                    int ny = tmp.y + dy[k];
                    if(nx<=0 || ny<=0 || nx>N || ny>N){
                        continue;
                    }
                    grow.add(new index(nx,ny,1));
                }
            }
        }
    }
    public static void winter(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] += feed[i][j];
            }
        }
    }
    public static class index{
        int x;
        int y;
        int year;
        public index(int x, int y, int year){
            this.x = x;
            this.y = y;
            this.year = year;
        }
    }
}
