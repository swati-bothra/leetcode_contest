class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        this.n=nums.length;
        this.numSlots=numSlots;
        this.nums=nums;
        dp=new int[numSlots+1][3][1<<n];
        for(int[][] a1:dp){
            for(int[] a2:a1){
                Arrays.fill(a2,-1);
            }
        }
        return util(1,2,0);
    }
    int n;
    int numSlots;
    int[] nums;
    int[][][] dp;
    int util(int slot, int remaining, int mask){
        if(slot>numSlots)return 0;
        if(dp[slot][remaining][mask]!=-1)return dp[slot][remaining][mask];
        int max=0;
        max=Math.max(max,util(slot+1,2,mask));
        
        if(remaining>0){
            for(int i=0;i<n;i++){
                if((mask&(1<<i))==0){
                    int t= util(slot,remaining-1,(mask|(1<<i)))+(nums[i]&slot);
                    max=Math.max(max,t);
                }
            }
        }
        return dp[slot][remaining][mask]=max;
    }
}
