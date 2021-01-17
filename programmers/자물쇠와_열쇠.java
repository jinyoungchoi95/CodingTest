import java.util.ArrayList;

class Solution {
    public boolean answer;
    public int m,n;
    public int lock_count;
    public boolean solution(int[][] key, int[][] lock) {
        answer = false;
        m = key.length;
        n = lock.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(lock[i][j]==0) lock_count++;
            }
        }
        if(lock_count==0) return true;

        ArrayList<index> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(key[i][j]==1) list.add(new index(i, j));
            }
        }
        if(list.size() < lock_count) return false;
        for(int r=0; r<=3; r++){
            ArrayList<index> tmplist = new ArrayList<>();
            for(int i=0; i<list.size(); i++){
                index tmp = list.get(i);
                tmplist.add(new index(m-tmp.y-1, tmp.x));
            }
            list = new ArrayList<>(tmplist);
            for(int i=-m+1; i<n; i++){
                for(int j=-m+1; j<n; j++){
                    int count = 0;
                    boolean check = true;
                    for(int k=0; k<list.size(); k++){
                        index tmp = list.get(k);
                        if(tmp.x+i<0 || tmp.y+j<0 ||tmp.x+i>=n ||tmp.y+j>=n) continue;

                        if(lock[tmp.x+i][tmp.y+j]==0) count++;
                        else if(lock[tmp.x+i][tmp.y+j]==1){
                            check = false;
                            break;
                        }
                    }
                    if(count==lock_count && check) return true;
                }
            }

        }



        return answer;
    }
    public class index{
        int x;
        int y;
        public index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}