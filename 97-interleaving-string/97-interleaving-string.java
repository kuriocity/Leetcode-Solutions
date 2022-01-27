class Solution {
    HashMap<String,Boolean> map=new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        
        return solve(s1,0,s2,0,s3,0);
    }
    
    boolean solve(String s1,int i, String s2,int j, String s3,int k){
        if(k==s3.length() && i==s1.length() && j==s2.length())
            return true;
       
        
        boolean ans;
        if(map.containsKey(i+" "+j+" "+k)){
            return map.get(i+" "+j+" "+k);
        }
        
        if(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j) && 
                k<s3.length() && s2.charAt(j)==s3.charAt(k))
            ans= solve(s1,i+1,s2,j,s3,k+1) || solve(s1,i,s2,j+1,s3,k+1);
        else if(i<s1.length() && k<s3.length() && s1.charAt(i)==s3.charAt(k))
            ans= solve(s1,i+1,s2,j,s3,k+1);
        else if(j<s2.length() && k<s3.length() && s2.charAt(j)==s3.charAt(k))
            ans= solve(s1,i,s2,j+1,s3,k+1);
        else
            ans= false;
        
        map.put(i+" "+j+" "+k,ans);
        
        return ans;
    }
}