import java.io.*;
import java.util.*;

public class F {
    public static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = inputReader.nextInt();


        List<Pair> ceil = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            int start = inputReader.nextInt();
            int finish = inputReader.nextInt();

            ceil.add(new Pair(start, finish));
        }

        ceil.sort((e1, e2) -> {
            if (e1.first < e2.first) {
                return -1;
            } else if (e1.first == e2.first && e1.second < e2.second) {
                return -1;
            }
            return 1;
        });

        int[] dp = new int[ceil.get(n - 1).getSecond() + 1];

        for (Pair pair : ceil) {
            dp[pair.getSecond()] = Math.max(dp[pair.getSecond()], dp[pair.getFirst()] + 1);
        }

        printWriter.println(Arrays.stream(dp).max().getAsInt());
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