class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        
        backtrack(digits, 0, new StringBuilder(), res, mp);
        
        return res;        
    }

    private void backtrack(String digits, int idx, StringBuilder sb, List<String> res, Map<Character, String> mp) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        String letters = mp.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            sb.append(letter);
            backtrack(digits, idx + 1, sb, res, mp);
            sb.deleteCharAt(sb.length() - 1);
        }
    }    
}