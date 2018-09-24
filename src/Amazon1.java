import java.util.ArrayList;
import java.util.List;

public class Amazon1 {

    public static void main(String[] args) {
        System.out.println(perfectNumberCheck(12));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int perfectNumberCheck(int n) {
        // Check if N is perfect or not
        // Return 1 or 0
        // INSERT YOUR CODE HERE
        if (n == 1) {
            return 1;
        }
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                a.add(i);
            }
        }
        return f(a, n, 0);
    }

    public static int f(List<Integer> a, int n, int s) {
        if(s==a.size())  return n==0?1:0;
        int[] b = new int[n + 1];

        if (a.get(s) > n)
            return 0;
        if (a.get(s) == n)
            return 1;
        else
            return f(a, n - a.get(s), s + 1);


    }
}
