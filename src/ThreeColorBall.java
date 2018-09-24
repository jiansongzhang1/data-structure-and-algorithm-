import java.util.Scanner;
public class ThreeColorBall {


        public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int np = scanner.nextInt();
            int nq = scanner.nextInt();
            int nr = scanner.nextInt();
            int res = fun(np ,nq,nr);
            System.out.println(res);

        }

        public static int fun(int a, int b, int c) {

            int[][][][] ans = new int[a+1][b+1][c+1][3];
            for(int i=0;i<3;i++){
                ans[0][0][0][i]=1;
            }
            for(int k=1;k<Math.min(a,b)+1;k++){
                    for(int j=0;j<3;j++){
                        if(k==1) ans[k][k][0][j]=2;
                        else
                        ans[k][k][0][j]= ans[k-1][k-1][0][j]*(2*k-1)*2;
                    }
            }
            for(int k=1;k<Math.min(c,b)+1;k++){
                for(int j=0;j<3;j++){
                    if(k==1) ans[0][k][k][j]=2;
                    else

                        ans[k][k][0][j]= ans[0][k-1][k-1][j]*(2*k-1)*2;
                }
            }
            for(int k=1;k<Math.min(a,c)+1;k++){
                for(int j=0;j<3;j++){
                    if(k==1) ans[k][k][0][j]=2;
                    else
                        ans[k][k][0][j]= ans[k-1][0][k-1][j]*(2*k-1)*2;
                }
            }
            for(int k=1;k<a+1;k++){
                for(int i=1;i<b+1;i++){
                    for(int j=1;j<c+1&&j>k-1-i;j++){
                        ans[k][i][j][0]=ans[k][i-1][j][1]+ans[k][i][j-1][2];
                        ans[k][i][j][1]=ans[k-1][i][j][0]+ans[k][i][j-1][2];
                        ans[k][i][j][2]=ans[k][i-1][j][1]+ans[k-1][i][j][0];
                    }
                }
            }

            return ans[a-1][b][c][0]+ans[a][b-1][c][1]+ans[a][b][c-1][2];
        }

    }

