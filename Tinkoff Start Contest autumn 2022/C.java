import java.io.*;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = inputReader.nextInt();

        int[] days = new int[n];

        int maxDecrease = Integer.MIN_VALUE;
        int minIncrease = Integer.MAX_VALUE;
        int increase = 0;
        int decrease = 0;

        for (int i = 0; i < n; ++i) {
            days[i] = inputReader.nextInt();
            if (i % 2 == 0) {
                increase += days[i];
                minIncrease = Math.min(minIncrease,days[i]);
            } else {
                decrease += days[i];
                maxDecrease = Math.max(maxDecrease, days[i]);
            }
        }

        long result = increase - decrease;

        if (maxDecrease <= minIncrease) {
            printWriter.println(result);
        } else {
            printWriter.println(result - 2L * (minIncrease - maxDecrease));
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