public class MaximumSubarrayDemo {
    public int maximumSubarray(int [] nums){
        int n=nums.length;
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0;i<n;i++){
            currSum+=nums[i];
            maxSum=Math.max(maxSum,currSum);

            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaximumSubarrayDemo maximumSubarrayDemo=new MaximumSubarrayDemo();

        int [] nums={1,0,-1,3,4,5};

        int ans=maximumSubarrayDemo.maximumSubarray(nums);
        System.out.println(ans);
    }
}
