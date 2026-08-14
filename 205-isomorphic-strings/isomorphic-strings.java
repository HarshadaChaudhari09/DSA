class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mps=new HashMap<>();
        HashMap<Character,Character> mpt=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(mps.containsKey(ch1)){
                if(mps.get(ch1)!=ch2){
                    return false;
                }
            }
                else{
                    mps.put(ch1,ch2);
                }
             if(mpt.containsKey(ch2)){
                if(mpt.get(ch2)!=ch1){
                    return false;
                }
            }
            else{
                mpt.put(ch2,ch1);
            }
        }
        return true;
    }
}