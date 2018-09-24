public class Leet168 {

    public static void main(String[] args) {
        System.out.println(f(52));
    }

    private static String f(int n) {
        StringBuffer s = new StringBuffer();
        int c = 0;
        while (n != 0) {
            c = n % 26;
            if (c == 0) {
                s.append('Z');
                if (n == 26) {
                    return s.reverse().toString();
                }
                n = (n - 26) / 26;
            } else {
                s.append((char) ('A' + c - 1));
                n = (n - c) / 26;
            }

        }
        return s.reverse().toString();
    }
}
