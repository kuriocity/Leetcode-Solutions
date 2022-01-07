class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list=new ArrayList<>();
        
        HashSet<String> set=new HashSet<>();
        for(String str : wordDict)
            set.add(str);
        
       return solve(s,set);
         //list;
        
    }
    
    //something should be returned if needs to be memoized!
    List<String> solve(String s,HashSet<String> set){
//         if(map.containsKey(s))
//             return map.get(s);
        
//         if(set.contains(s))
//             return true;
        
        List<String> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            
            String str=s.substring(0,i+1);
            
            if(set.contains(str)){
                
                if(i==s.length()-1){
                    list.add(str);
                    return list;
                }
                List<String> rem=solve(s.substring(i+1),set);
                for(String sentence:rem){
                    list.add(str+" "+sentence);
                }
                
            }
        }
        //map.put(s,ans);
        
        return list;
    }
}