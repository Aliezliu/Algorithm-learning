import java.util.*;
public class Solution {
    /*1.O(nlgn)算法
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
    }*/

    //2.O(nlgk)算法
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int len = input.length;
        ArrayList<Integer> arraylist = new ArrayList<>();
        if(k > len || len <= 0 || k <= 0)
            return arraylist;
        //自底向上建堆
        for(int i = (k >> 1) - 1; i >= 0; i--) 
            Max_Heap(input, i, k);
        
        //自上到下调整
        for(int j = k; j < len; j++) {
            if(input[j] < input[0]) {
                input[0] = input[j];
                Max_Heap(input, 0, k);
            } else
               continue;
        }
        
        for(int i = 0; i < k; i++)
            arraylist.add(input[i]);
        return arraylist;
    }
    
    /**
     * 最大堆化
     * @param a
     * @param i
     * @param k
     */
    public void Max_Heap(int[] a, int i, int k) {
        int left = (i << 1) + 1;
        int right = (i << 1) + 2;
        int largest = i;
        if(left <= k - 1 && a[left] > a[i])
            largest = left;
        if(right <= k - 1 && a[right] > a[largest])
            largest = right;
        if(largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            Max_Heap(a, largest, k);
        }
    }
}
