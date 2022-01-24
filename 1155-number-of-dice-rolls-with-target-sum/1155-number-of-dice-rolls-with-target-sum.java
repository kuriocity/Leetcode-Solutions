class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int [][]table=new int[n+1][target+1];
        for(int []t:table)
            Arrays.fill(t,-1);
        
        return solve(n,k,target,table)%1000000007;
    }
    
    int solve(int n, int k, int target,int [][]table){
        if(n==0 && target==0)
            return 1;
        if(n==0 || target<=0)
            return 0;
  
            
        if(table[n][target]!=-1)
            return table[n][target];
        
        int ans=0;
        for(int i=1;i<=k;i++){
            
            ans=(ans+solve(n-1,k,target-i,table))%1000000007;
            
        }
        return table[n][target]=ans%1000000007;
    }
}