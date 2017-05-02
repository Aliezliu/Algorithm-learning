public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty())//注意两种判空
            return 0;
        int len = s.length();
        int maxlen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0, i = -1; j < len; j++) {
        	if(map.containsKey(s.charAt(j)))
        		i = Math.max(map.get(s.charAt(j)), i);//eg. "abcdeca"
        	map.put(s.charAt(j), j);
        	maxlen = Math.max(maxlen, j - i);
        }
        return maxlen;
    }
}