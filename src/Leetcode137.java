public class Leetcode137 {

    public static void main(String[] args) {
        int[] a={1,1,1,-1,-1,-1,3};
        System.out.println(f(a));
    }

    private static int f(int[] nums) {
        int length = nums.length;
        int result = 0;
        for(int i = 0; i<32; i++){
            int count = 0;
            int mask = 1<< i;
            for(int j=0; j<length; j++){
                if((nums[j] & mask)!=0 )
                    count++;
            }
            if(count %3 !=0)
                result |= mask;
        }
        return result;

    }
}
