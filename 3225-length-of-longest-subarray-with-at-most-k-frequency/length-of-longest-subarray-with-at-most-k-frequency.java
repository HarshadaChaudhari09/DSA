class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        int left = 0;
        int maxl = 0;

        for (int right = 0; right < nums.length; right++) {

            // Increase frequency of nums[right]
            mp.put(nums[right], mp.getOrDefault(nums[right], 0) + 1);

            // If frequency exceeds k
            while (mp.get(nums[right]) > k) {

                mp.put(nums[left], mp.get(nums[left]) - 1);

                left++;
            }

            // Current window length
            maxl = Math.max(maxl, right - left + 1);
        }

        return maxl;
    }
}