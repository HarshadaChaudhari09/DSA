class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        int maxfreq=0;
        int ans=0;
        for(int key:mp.keySet()){
         if(mp.get(key)>maxfreq){
          maxfreq=mp.get(key);
          ans=key;
         }
        }
        return ans;
    }
}