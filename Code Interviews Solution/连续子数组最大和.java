import java.util.*;
public class Main{//动态规划
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        int i = 0, res = 0;
        while(sc.hasNext()) {
            a[i] = sc.nextInt();
            if(i == 0) {
                dp[i] = a[i];
                res = dp[i];	
            }
            else
                dp[i] = Math.max(dp[i-1] + a[i], a[i]);
            res = Math.max(res, dp[i]);
            i++;
        }
        System.out.println(res);
        sc.close();
    }
}