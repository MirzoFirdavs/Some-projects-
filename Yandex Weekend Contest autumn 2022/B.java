import java.io.*;
import java.util.*;

import static java.lang.Character.isDigit;

public class B {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        String s = scanner.nextLine();

        s = s.replaceAll(",", " ");
        s = s.replaceAll("]", " ");
        s = s.replaceAll("\\[", "");

        List<Long> nums = new ArrayList<>();
        List<String> a = new ArrayList<>();
        Map<Long, Integer> map = new TreeMap<>();

        boolean flag = false;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '-') {
                flag = true;
            }
            if (isDigit(s.charAt(i))) {
                a.add(String.valueOf(s.charAt(i)));
            }

            if (s.charAt(i) == ' ' && a.size() != 0) {
                if (!flag) {
                    nums.add(Long.parseLong(String.join("", a)));
                } else {
                    nums.add(-Long.parseLong(String.join("", a)));
                }

                a.clear();
                flag = false;
            }
        }

        for (Long num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.merge(num, 1, Integer::sum);
            }
        }

        int mx = -10;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            mx = Math.max(mx, entry.getValue());
        }

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mx) {
                printWriter.print(entry.getKey() + " ");
            }
        }

        printWriter.close();
    }
}