import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        Map<String, Integer> map = new TreeMap<>();

        List<String> words = new ArrayList<>();
        List<String> result = new ArrayList<>();

        int n = inputReader.nextInt();

        for (int i = 0; i < n; ++i) {
            String str = inputReader.next();
            words.add(str);

            int cntLeft = 1;
            int cntRight = 1;

            while (cntLeft + cntRight <= str.length() - 2) {
                String i10n = str.substring(0, cntLeft)
                        + (str.length() - cntLeft - cntRight)
                        + str.substring(str.length() - cntRight);

                map.putIfAbsent(i10n, 0);
                map.put(i10n, map.get(i10n) + 1);

                cntLeft++;
                cntRight++;
            }
        }

        for (int i = 0; i < n; ++i) {
            int cntLeft = 1;
            int cntRight = 1;

            boolean flag = false;

            while (cntLeft + cntRight <= words.get(i).length() - 2) {
                String i10n = words.get(i).substring(0, cntLeft)
                        + (words.get(i).length() - cntLeft - cntRight)
                        + words.get(i).substring(words.get(i).length() - cntRight);

                if (map.get(i10n) == 1) {
                    result.add(i10n);
                    flag = true;
                    break;
                }

                cntLeft++;
                cntRight++;
            }

            if (!flag) {
                result.add(words.get(i));
            }
        }

        for (String element : result) {
            printWriter.println(element);
        }

        printWriter.close();
    }


    public static class InputReader {
        public final BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public final String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        @SuppressWarnings("unused")
        public final int nextInt() {
            return Integer.parseInt(next());
        }

        @SuppressWarnings("unused")
        public final long nextLong() {
            return Long.parseLong(next());
        }
    }
}