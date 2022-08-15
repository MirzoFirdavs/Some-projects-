import java.io.*;
import java.util.*;

public class B {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        Map<String, Integer> map = new HashMap<>();

        int n = inputReader.nextInt();

        for (int i = 0; i < n; ++i) {
            String[] team = new String[3];

            team[0] = inputReader.next();
            team[1] = inputReader.next();
            team[2] = inputReader.next();

            Arrays.sort(team);

            String s = Arrays.toString(team);

            if (map.containsKey(s)) {
                map.merge(s, 1, Integer::sum);
            } else {
                map.put(s, 1);
            }
        }

        int maxCount = -1;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }

        printWriter.println(maxCount);
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