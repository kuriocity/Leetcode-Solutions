class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //List<List<Integer>> list=new LinkedList<>();
        HashMap<String,List<List<Integer>>> map=new HashMap<>();
        return solve(candidates,candidates.length-1, target,map);
    }
    
    List<List<Integer>> solve(int[] arr,int index,int target,HashMap<String,List<List<Integer>>> map){
        List<List<Integer>> list=new LinkedList<>();
        
        if(map.containsKey(index+" "+target))
            return map.get(index+" "+target);
            
        if(index==-1){
            if(target==0)
                list.add(new LinkedList<>());
            return list;
        }
        
        if(arr[index]<=target){
            List<List<Integer>> list2 = solve(arr,index, target-arr[index],map);
            
            for(List<Integer> obj:list2){
                List<Integer> t=new LinkedList<Integer>(obj);
                t.add(arr[index]);
                list.add(t);
            }
            List<List<Integer>> list3 = solve(arr,index-1, target,map);
            list.addAll(new LinkedList<>(list3));
            
        }else{
            return solve(arr,index-1, target,map);
        }
        List<List<Integer>> mapList=new LinkedList<>();
        //mapList=new LinkedList<List<Integer>>(list).stream().map(l->new LinkedList<Integer>(l)).collect(Collectors.toList());
        
        for(List<Integer> l:list){
            mapList.add(new LinkedList<>(l));
        }
        
        map.put(index+" "+target,mapList);
        return list;
    }
}