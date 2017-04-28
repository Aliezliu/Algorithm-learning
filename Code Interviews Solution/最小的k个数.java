import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int len = input.length;
        ArrayList<Integer> arraylist = new ArrayList<>();
        if(k > len || len <= 0 || k <= 0)
            return arraylist;
        Arrays.sort(input);
        arraylist.add(input[0]);
        for(int i = 1; i < len && k > 1; i++) {
            if(arraylist.contains(input[i]))
                continue;
            arraylist.add(input[i]);
            k--;
        }
        return arraylist;
    }
}