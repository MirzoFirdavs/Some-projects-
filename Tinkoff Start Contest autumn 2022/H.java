import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class H {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int n = inputReader.nextInt();
        int query = inputReader.nextInt();

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            strings.add(inputReader.next());
        }

        int[] result = new int[query];

        for (int i = 0; i < query; ++i) {
            String prefix = inputReader.next();
            String suffix = inputReader.next();

            for (String string: strings) {
                if (string.startsWith(prefix) && string.endsWith(suffix)) {
                    result[i]++;
                }
            }

            printWriter.println(result[i]);
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