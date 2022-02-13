class Solution {
    public long minimumRemoval(int[] beans) {
        int n=beans.length;
        long sum=Arrays.stream(beans).mapToLong(i->i).sum();
        Arrays.sort(beans);
        long ans=sum;
        int current=0;
        for(int i=0;i<n;i++){
            long delta=(beans[i]-current)*1L;
            long temp=delta*(n-i);
            sum=sum-temp;
            ans=Math.min(ans,sum);
            sum+=beans[i];
            current=beans[i];
        }
        return ans;
    }
}
