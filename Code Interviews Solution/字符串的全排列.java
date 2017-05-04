import java.util.*;
public class Solution {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则打印出由字符a,b,c
     * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {//eg. "CaEcFg"——> "CEFacg"
        //1.递归回溯
        ArrayList<String> al = new ArrayList<>();
        if(str == null || str.isEmpty())
            return al;
        dfs(al, str.toCharArray(), 0);
        Collections.sort(al);
        return al;
        /*2.递归法
        ArrayList<String> al = new ArrayList<>();
        if(str == null || str.isEmpty())
            return al;
        int len = str.length();
        if(len == 1) {
            al.add(str);
            return al;
        }
        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);
        String sorted_str = new String(sorted);
        String left = sorted_str.substring(0, 1);
        String res;
        ArrayList<String> right_al = Permutation(sorted_str.substring(1, len));
        for(String s : right_al) {
            res = left + s;
            if(!al.contains(res))
                al.add(res);
        }
        for(int i = 1; i < len; i++) {
            char tmp = sorted[0];
            sorted[0] = sorted[i];
            sorted[i] = tmp;
            left = new String(sorted, 0, 1);
            right_al = Permutation(new String(sorted, 1, len - 1));
            for(String s : right_al) {
                res = left + s;
                if(!al.contains(res))
                    al.add(res);
            }
        }
        return al;*/
    }
    
    public void dfs(ArrayList<String> sal, char[] cstr, int k){
        if(k == cstr.length) {
            String s = new String(cstr);
            if(!sal.contains(s))
                sal.add(s);
            return;
        } else {
            for(int i = k; i < cstr.length; i++) {
                swap(cstr, i, k);
                dfs(sal, cstr, k + 1);
                swap(cstr, i, k);
            }
        }
    }
    
    public void swap(char[] s, int i, int j){
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}