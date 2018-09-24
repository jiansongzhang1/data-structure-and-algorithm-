import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> a = new ArrayList<>();
        while (in.hasNext()) {
            a.add(in.next());
        }
        List<String> ans = f(a);
        for (String b :
                ans) {
            System.out.print(b + " ");
        }
    }

    private static List<String> f(List<String> a) {
        if (a.size() <= 3) {
            return a;
        }
        List<String> ans = new ArrayList<>();  //返回结果
        Map<Integer, String> m = new TreeMap<>();//按字典序排序
        Map<Integer, String> m1 = new HashMap<>();//存重复结果
        Set<Character> a1 = new HashSet<>();//存字母集，用于分区
        a1.add('q');
        a1.add('w');
        a1.add('e');
        a1.add('r');
        a1.add('t');
        a1.add('a');
        a1.add('s');
        a1.add('d');
        a1.add('f');
        a1.add('g');
        a1.add('z');
        a1.add('x');
        a1.add('c');
        a1.add('v');
        for (int i = 1; i < a.size(); i++) {
            int c = 0;
            if (a.get(i).length() == a.get(0).length()) {
                for (int j = 0; j < a.get(i).length(); j++) {
                    if (a.get(0).charAt(j) == a.get(i).charAt(j)) {
                        continue;
                    } else {
                        if (a1.contains(a.get(0).charAt(j)) && a1.contains(a.get(i).charAt(j))) {
                            c += 1;
                        } else if (a1.contains(a.get(0).charAt(j)) || a1.contains(a.get(i).charAt(j))) {
                            c += 2;
                        } else {
                            c += 1;
                        }
                    }
                }
            } else {
                int h = 0;
                //当前单词比第一个单词短，按首单词逐位比较，统计有多少得1分的(在同一字母范围)
                if (a.get(0).length() > a.get(i).length()) {
                    for (int j = 0; j < a.get(0).length(); j++) {
                        if ((a1.contains(a.get(0).charAt(j)) && a1.contains(a.get(i).charAt(h))) ||
                                !a1.contains(a.get(0).charAt(j)) && !a1.contains(a.get(i).charAt(h))) {
                            c += 1;
                            h++;
                        }
                    }
                } else {  //当前单词比首单词长
                    for (int j = 0; j < a.get(j).length(); j++) {
                        if ((a1.contains(a.get(0).charAt(h)) && a1.contains(a.get(i).charAt(j))) ||
                                !a1.contains(a.get(0).charAt(h)) && !a1.contains(a.get(i).charAt(j))) {
                            c += 1;
                            h++;
                        }
                    }
                }
      //总分=删除或增加*3+同一区间替换+不同区间替换
                c += Math.abs(a.get(0).length() - a.get(i).length()) * 3 + c +
                        Math.min(a.get(0).length(), a.get(i).length()) * 2;
            }
            if (m.containsKey(c)) {
                m1.put(c, m.get(c));//存重复值
            }
            m.put(c, a.get(i));
        }
        Iterator<Map.Entry<Integer, String>> it = m.entrySet().iterator();
        for (int i = 0; i < 3; i++) {
            Map.Entry<Integer, String> kk = it.next();
            for (int ma :
                    m1.keySet()) {
                if (ma == kk.getKey()) {
                    ans.add(m1.get(ma));
                }
            }
            if (ans.size() == 3) {
                break;
            }
            ans.add(m.get(kk.getKey()));
            if (i == 2 && ans.size() < 3) {
                ans.add(m.get(kk.getKey()));
            }
        }
        return ans;
    }
}