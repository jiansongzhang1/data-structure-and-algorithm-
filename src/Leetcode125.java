public class Leetcode125 {

    public static void main(String[] args) {
        int[] s = {1, 2, 5};
        System.out.println(count(s, 11));
    }

    private static int count(int[] s, int t) {
        if (s == null || s.length == 0 || t < 0) {
            return 0;
        }
        int dp[] = new int[t + 1];
        for (int i = 1; i < t + 1; i++) {
            dp[i] = t + 1;
        }
        for (int i = 1; i < t + 1; i++) {
            for(int j =0;j<s.length;j++){
                if(s[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-s[j]]+1);
                }
            }
        }
        return dp[t]>t?-1:dp[t];
    }
}
