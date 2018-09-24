import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> a = new ArrayList<>();
        while (in.hasNextLine()) {
            a.add(in.nextLine());
        }
        Map<String, Integer> p = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            String[] b = a.get(i).split(" ");
            int av = 0;
            for (int j = 1; j < b.length; j++) {
                av += Integer.parseInt(b[j]);
            }
            av = av / (b.length - 1);
            p.put(b[0], av);
        }
        List<Map.Entry<String, Integer>> list_Data = new ArrayList<Map.Entry<String, Integer>>(p.entrySet());
        Collections.sort(list_Data, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : list_Data) {
            System.out.println(entry.getKey() + " "
                    + entry.getValue());
        }
    }
}
