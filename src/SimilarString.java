import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimilarString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        in.close();
        int a = f(s, t);
        System.out.println(a);
    }

    private static int f(String s, String t) {
        if (t.length() > s.length() || s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i <= s.length() - t.length(); i++) {
            if (isSimilar(s.substring(i, i + t.length()), t)) {
                ans += 1;
            }
        }
        return ans;
    }

    private static boolean isSimilar(String substring, String t) {
        Map<Character,Integer> s= new HashMap<>();
        Map<Character,Integer> y= new HashMap<>();
        for(int i =0;i <t.length(); i++){
            if(!s.containsKey(substring.charAt(i))&&!y.containsKey(t.charAt(i))){
                s.put(substring.charAt(i),i);
                y.put(t.charAt(i),i);
            } else if(!s.containsKey(substring.charAt(i))&&y.containsKey(t.charAt(i))){
                return false;
            } else if(s.containsKey(substring.charAt(i))&&!y.containsKey(t.charAt(i))){
                return false;
            } else {
                if(s.get(substring.charAt(i))==y.get(t.charAt(i))){
                    continue;
                } else{
                    return false;
                }
            }
        }
        return true;
    }
}
