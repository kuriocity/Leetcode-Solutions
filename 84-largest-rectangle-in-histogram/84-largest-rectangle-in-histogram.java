class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> stack=new Stack<>();
        int n=h.length;
        //int left[]=new int[n];
        int right[]=new int[n];
        
        //Nearest Smallest Element
        for(int i=n-1;i>=0;i--){
            while(stack.isEmpty()==false && h[stack.peek()]>=h[i])
                stack.pop();
            if(stack.isEmpty())
                right[i]=n;
            else
                right[i]=stack.peek();
            
            stack.push(i);
              
        }
        stack.clear();//=new Stack<>();
        int area=0;
        
        for(int i=0;i<n;i++){
            int left=0;
            while(stack.isEmpty()==false && h[stack.peek()]>=h[i])
                stack.pop();
            if(stack.isEmpty())
                left=-1;
            else
                left=stack.peek();
            
            stack.push(i);
            
            area=Math.max((right[i]-left-1)*h[i],area);
                
        }
        // for(int i=0;i<n;i++){
        //     area=Math.max((right[i]-left[i]-1)*h[i],area);
        // }
        
        return area;
        
        
    }
}