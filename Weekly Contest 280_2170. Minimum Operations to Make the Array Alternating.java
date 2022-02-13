class Solution {
    public int minimumOperations(int[] nums) {
        if(nums.length==1)return 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i=0;i<nums.length;i=i+2){
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<nums.length;i=i+2){
            map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
        }
        
        int sum1 = map1.values().stream().mapToInt(i->i).sum();
        int sum2 = map2.values().stream().mapToInt(i->i).sum();
        
        LinkedList<pair> l1=new LinkedList<>();
        for(int k:map1.keySet()){
            l1.add(new pair(k,map1.get(k)));
        }
        
        LinkedList<pair> l2=new LinkedList<>();
        for(int k:map2.keySet()){
            l2.add(new pair(k,map2.get(k)));
        }
        
        Collections.sort(l1,(a,b)->b.j-a.j);
        Collections.sort(l2,(a,b)->b.j-a.j);
        // System.out.println(l1.toString());
        // System.out.println(l2.toString());
        
        if(l1.get(0).i==l2.get(0).i){
            int ans=Integer.MAX_VALUE;
            if(l1.size()>1){
                ans=Math.min(ans,(sum1-l1.get(1).j)+(sum2-l2.get(0).j));
            }else{
                ans=Math.min(ans,(sum1)+(sum2-l2.get(0).j));
            }
            if(l2.size()>1){
                ans=Math.min(ans,(sum1-l1.get(0).j)+(sum2-l2.get(1).j));
            }else{
                ans=Math.min(ans,(sum1-l1.get(0).j)+(sum2));
            }
            return ans;
        }else{
            return (sum1-l1.get(0).j)+(sum2-l2.get(0).j);
        }
    }
    class pair{
        int i;int j;
        pair(int i,int j){
            this.i=i;this.j=j;
        }
        public String toString(){
            return i+"-"+j;
        }
    }
}
