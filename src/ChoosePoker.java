import java.util.Scanner;

public class ChoosePoker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] poker = new int[n];
        for (int i = 0; i < poker.length; i++) {
            poker[i] = in.nextInt();
        }
        in.close();
        int max = choosePoker(poker);
        System.out.println(max);
    }

    private static int choosePoker(int[] poker) {
        if (poker == null) {
            return 0;
        }
        if (poker.length == 1) {
            return poker[0];
        }
        return Math.max(f(poker, 0, poker.length - 1), s(poker, 0, poker.length - 1));
    }

    private static int f(int[] poker, int s, int e) {
        if (e == s) {
            return poker[s];
        }
        return Math.max(poker[s] + s(poker, s + 1, e), poker[e] + s(poker, s, e - 1));
    }

    private static int s(int[] poker, int s, int e) {
        if (s == e) {
            return 0;
        }
        return Math.min(f(poker, s + 1, e), f(poker, s, e - 1));
    }
}
