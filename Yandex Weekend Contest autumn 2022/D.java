import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        TreeMap<Long, TreeMap<Long, Long>> treeByMinValue = new TreeMap<>();
        TreeMap<Long, TreeMap<Long, Long>> treeByMinIndex = new TreeMap<>();

        int query = inputReader.nextInt();

        for (int i = 0; i < query; ++i) {
            int operation = inputReader.nextInt();

            if (operation == 1) {
                long firstElement = inputReader.nextLong();
                long difference = inputReader.nextLong();
                long index = inputReader.nextLong();

                if (!treeByMinValue.containsKey(firstElement)) {
                    treeByMinValue.put(firstElement, new TreeMap<>(Map.of(index, difference)));
                } else {
                    treeByMinValue.get(firstElement).put(index, difference);
                }

                treeByMinIndex.put(index, new TreeMap<>(Map.of(firstElement, difference)));

            } else if (operation == 2) {
                long index = inputReader.nextLong();

                TreeMap<Long, Long> map = treeByMinIndex.get(index);

                long fistElement = map.firstKey();

                treeByMinIndex.remove(index);
                treeByMinValue.remove(treeByMinValue.get(fistElement).remove(index));

                if (treeByMinValue.get(fistElement).isEmpty()) {
                    treeByMinValue.remove(fistElement);
                }
            } else if (operation == 3) {
                long firstElement = treeByMinValue.firstKey();
                long index = treeByMinValue.get(treeByMinValue.firstKey()).firstKey();
                long difference = treeByMinValue.get(treeByMinValue.firstKey()).get(treeByMinValue.get(treeByMinValue.firstKey()).firstKey());

                treeByMinIndex.remove(index);
                treeByMinIndex.put(index, new TreeMap<>(Map.of(firstElement + difference, difference)));
                treeByMinValue.remove(treeByMinValue.get(firstElement).remove(index));

                if (treeByMinValue.get(firstElement).isEmpty()) {
                    treeByMinValue.remove(firstElement);
                }

                if (!treeByMinValue.containsKey(firstElement + difference)) {
                    treeByMinValue.put(firstElement + difference, new TreeMap<>(Map.of(index, difference)));
                } else {
                    treeByMinValue.get(firstElement + difference).put(index, difference);
                }

                printWriter.println(firstElement);
            }
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