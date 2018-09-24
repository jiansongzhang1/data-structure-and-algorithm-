import java.util.Scanner;

public class Choc {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
                x[i] = in.nextInt();
        }
        int ans = f(x,0);
        System.out.println(ans);
    }

    private static int f(int[] x,int s) {
        boolean f = false;
        int[] dp=new int[x.length];
        int cou=0,an=1;
        for(int i=x.length-1;i>-1;i--){
            if(x[i]==1){
                f=true;
            }
            if(x[i]==0){
               cou++;
            }
            f=!f;
            if(!f&&cou!=0){
                an*=(cou+1);
            }
        }
        return an;
    }
}
