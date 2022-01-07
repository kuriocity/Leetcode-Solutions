class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list=new ArrayList<>();
        
        HashSet<String> set=new HashSet<>();
        for(String str : wordDict)
            set.add(str);
        
        solve(s,set,list,"");
        return list;
        
    }
    
    
    void solve(String s,HashSet<String> set,List<String> list,String sentence){
//         if(map.containsKey(s))
//             return map.get(s);
        
//         if(set.contains(s))
//             return true;
        
        
        for(int i=0;i<s.length();i++){
            
            String str=s.substring(0,i+1);
            
            if(set.contains(str)){
                
                if(i==s.length()-1){
                    sentence+=str;
                    list.add(sentence);
                    return;
                }
                solve(s.substring(i+1),set,list,sentence+str+" ");
                
            }
        }
        //map.put(s,ans);
    }
}