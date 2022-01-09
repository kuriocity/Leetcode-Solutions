class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //List<List<Integer>> list=new LinkedList<>();
        return solve(candidates,candidates.length-1, target);
    }
    
    List<List<Integer>> solve(int[] arr,int index,int target){
        List<List<Integer>> list=new LinkedList<>();
        
        if(index==-1){
            if(target==0)
                list.add(new LinkedList<>());
            return list;
        }
        
        if(arr[index]<=target){
            List<List<Integer>> list2 = solve(arr,index, target-arr[index]);
            
            for(List<Integer> obj:list2){
                obj.add(arr[index]);
                list.add(obj);
            }
            List<List<Integer>> list3 = solve(arr,index-1, target);
            list.addAll(list3);
            
        }else{
            return solve(arr,index-1, target);
        }
        
        return list;
    }
}