class Solution {
    public String reversePrefix(String word, char ch) {

        String ans = "";

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) == ch) {

                for (int j = i; j >= 0; j--) {
                    ans += word.charAt(j);
                }

                ans += word.substring(i + 1);

                return ans;
            }
        }

        return word;
    }
}