import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int x1 = inputReader.nextInt();
        int y1 = inputReader.nextInt();
        int x2 = inputReader.nextInt();
        int y2 = inputReader.nextInt();
        int x3 = inputReader.nextInt();
        int y3 = inputReader.nextInt();
        int x4 = inputReader.nextInt();
        int y4 = inputReader.nextInt();

        int distX = Math.max(x1, Math.max(x2, Math.max(x3, x4))) - Math.min(x1, Math.min(x2, Math.min(x3, x4)));
        int distY = Math.max(y1, Math.max(y2, Math.max(y3, y4))) - Math.min(y1, Math.min(y2, Math.min(y3, y4)));
        int maxDist = Math.max(distX, distY);

        printWriter.println(maxDist * maxDist);
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