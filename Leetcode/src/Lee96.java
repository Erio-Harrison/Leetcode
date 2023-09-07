package src;

public class Lee96 {
    public int numTrees(int n) {
        int[] tree =  new int[n+1];
        tree[0]=1;
        tree[1]=1;
        for(int i=2;i<n;i++){
            for(int j=1;j<=i;j++){
                tree[i] += tree[j-1]*tree[i-j];
            }
        }
        return tree[n];
    }
}
