有n个房间，房间之间有通道相连，一共有n-1个通道，每两个房间之间都可以通过通道互相到达。

第i个房间有x_ix i个金币。

现在牛牛想通过封闭一些通道来把n个房间划分成k个互相不连通的区域，他希望这k个区域内部的金币数目和都大于等于m，
你需要告诉他这是否可行。
import java.util.*;


public class Solution {
    /**
     * 连通块
     * @param n int整型 
     * @param k int整型 
     * @param m int整型 
     * @param u int整型一维数组 
     * @param v int整型一维数组 
     * @param x int整型一维数组 
     * @return bool布尔型
     */
    private ArrayList<Integer>[] arr;
    private int res;
    public boolean solve (int n, int k, int m, int[] u, int[] v, int[] x) {
        // write code here
        arr=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            arr[u[i]].add(v[i]);
            arr[v[i]].add(u[i]);
        }
        
        dfs(1,0,x,m);
        return res>=k;
    }
    
    private int dfs(int cur,int pre,int[] x,int m){
        int money=x[cur-1];
        for(int i:arr[cur]){
            if(i!=pre){
                money+=dfs(i,cur,x,m);
            }
        }
        
        if(money>=m){
            money=0;
            res++;
        }
        return money;
    }
}


