/* calculate the number of N node different binary tree */
public class NodeOfNBinnaryTree {

    public static void main(String[] args) {
        int nodeNumbber = calculate(4);
        System.out.println(nodeNumbber);
    }

    private static int calculate(int n) {
        int[] ans = new int[n + 1];
        ans[0] = ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                ans[i] += ans[i - 1 - j] * ans[j];
            }
        }
        return ans[n];
    }
}


