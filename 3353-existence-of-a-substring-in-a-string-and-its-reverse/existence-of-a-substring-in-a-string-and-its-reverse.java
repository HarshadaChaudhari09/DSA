class Solution {

    String reverse(String s) {
        String ans = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            ans += s.charAt(i);
        }

        return ans;
    }

    public boolean isSubstringPresent(String s) {

        String rev = reverse(s);

        for (int i = 0; i < s.length() - 1; i++) {

            String sub = s.substring(i, i + 2);

            if (rev.contains(sub)) {
                return true;
            }
        }

        return false;
    }
}