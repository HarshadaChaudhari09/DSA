class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int i=0;
        int arr[]=new int[set.size()];
        for(int num: set){
             arr[i]=num;
             i++;
        }
        Arrays.sort(arr);
        if(arr.length<3){
        return arr[arr.length-1];
        }
        return arr[arr.length-3];
    }
}