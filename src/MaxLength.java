public class MaxLength {

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1};
        int len = f(a, 6);
        System.out.println(len);
    }

    private static int f(int[] a, int t) {
        if (t < 1 || a.length == 0 || a == null) {
            return 0;
        }
        int L=0,R=0;
        int sum=a[0];
        int l=0;
        while(R<a.length){
            if(sum==t){
                l=Math.max(l,R-L+1);
                sum-=a[L++];
            } else if(sum<t){
                R++;
                if(R==a.length)   break;
                sum+=a[R];
            } else {
                sum-=a[L++];
            }
        }
        return l;
    }
}
