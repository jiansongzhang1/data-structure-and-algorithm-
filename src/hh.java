import java.util.Arrays;
import java.util.Scanner;
//局长吃点心
public class hh {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[a[0]];
        for (int i = 0; i < a[0]; i++) {
            b[i] = in.nextInt();
        }
        int[] c = new int[a[1]];
        String[] d = new String[a[1]];
        for (int i = 0; i < a[1]; i++) {
            d[i] = in.next();
            c[i] = in.nextInt();
        }
        in.close();
        System.out.println(f(b, c, d, a[2]));

    }

    private static int f(int[] b, int[] c, String[] d, int p) {
        for (int i = 0; i < c.length; i++) {
            if (d[i].equals("A")) {
                b[c[i] - 1] += 1;
            }
            if (d[i].equals("B")) {
                b[c[i] - 1] -= 1;
            }

        }
        int k = b[p - 1], a = 0, l = 0;
        Arrays.sort(b);
        for (int i = b.length - 1; i >= 0; i--) {
            if (b[i] == k) {
                a += 1;
                l = b.length - i;
            }
        }
        return l - a + 1;

    }


}
