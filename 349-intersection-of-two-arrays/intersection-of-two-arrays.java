class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int j=0;
        
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        HashSet<Integer>result=new HashSet<>();
       
        for(int i=0;i<nums2.length;i++) {   
            if(set.contains(nums2[i])){
              result.add(nums2[i]);
            }
        }
        int arr[]=new int[result.size()];
        for(int num: result){
            arr[j]=num;
            j++;
        }
        return arr;
    }
}