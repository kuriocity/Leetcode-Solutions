class Solution {
    public int uniquePaths(int m, int n) {
        //ways=0;
        //System.out.println(ways);
        int [][]table=new int[m][n];
        for(int []row:table)
            Arrays.fill(row,-1);
        return UPR(m,n,0,0,table);
    }
    //static int ways;
    public static int UPR(int m, int n,int i,int j,int [][]table) {
        if(i>=m || j>=n)
            return 0;
        
        if(table[i][j]!=-1)
            return table[i][j];
        
        if(i==m-1 && j==n-1){
             //ways++;
            //System.out.println(i+" "+j);
            //System.out.println("# "+ways);
            return 1;
        }
        return table[i][j] = UPR(m,n,i+1,j,table) + UPR(m,n,i,j+1,table);
        
    }
}