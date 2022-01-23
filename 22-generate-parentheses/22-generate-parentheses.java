class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        
        solve(n*2,0,"",ans);
        
        return ans;
    }
    
    void solve(int n,int k,String s,List<String> ans){
        if(k<0 || n<0)
            return;
        
        if(n==0 && k==0)
            ans.add(s);
        
        solve(n-1,k+1,s+"(",ans);
        solve(n-1,k-1,s+")",ans);

    }
}