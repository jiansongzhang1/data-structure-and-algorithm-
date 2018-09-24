import java.util.ArrayList;
import java.util.List;

public class Amazon {

    public static void main(String[] args) {
        String[] a={};
        System.out.println(canArrangeWords(a));
    }
    public static int canArrangeWords(String arr[])
    {
        List<Character> p=new ArrayList<>();
        List<Character> h=new ArrayList<>();
        // INSERT YOUR CODE HERE
        for(int i=0;i<arr.length;i++){
            p.add(arr[i].charAt(0)) ;
            h.add(arr[i].charAt(arr[i].length()-1));
        }
        boolean j=false;
        boolean k=false;
        for(int i=0;i<arr.length;i++){
         //   if(h.contains())
        }
return 0;
    }
}
