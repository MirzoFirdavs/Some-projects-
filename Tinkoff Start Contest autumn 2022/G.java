import java.io.*;
import java.util.*;

public class G {
    private static int generateLengthOfPath(String subShop) {
        int result = 0;
        int index = 0;
        int size = subShop.length();

        Set<Character> uniqueElements = new TreeSet<>();

        for (int i = 0; i < size; ++i) {
            uniqueElements.add(subShop.charAt(i));
        }

        List<Character> uniqueElementsList = new ArrayList<>(uniqueElements);

        int i = 0;
        int j = 0;

        while (i < uniqueElementsList.size()) {
            if (j == size) {
                j = 0;
            }

            if (subShop.charAt(j) == uniqueElementsList.get(i) && j >= index) {
                result += j - index;
                index = j;
                i++;
            } else if (subShop.charAt(j) == uniqueElementsList.get(i) && j < index) {
                result += (size - index + j);
                index = j;
                i++;
            }

            ++j;
        }

        return result;
    }

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        String shop = inputReader.next();

        int query = inputReader.nextInt();

        for (int i = 0; i < query; ++i) {
            int left = inputReader.nextInt() - 1;
            int right = inputReader.nextInt();

            String subShop = shop.substring(left, right);

            printWriter.println(generateLengthOfPath(subShop));
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