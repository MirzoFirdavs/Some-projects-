import java.io.*;
import java.util.*;

public class E {
    public static class Pair implements Comparable<Pair> {
        private String surname;
        private int index;

        public Pair(String surname, int index) {
            this.surname = surname;
            this.index = index;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(Pair obj) {
           return this.surname.compareTo(obj.surname);
        }
    }

    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        Map<String, Pair> map = new TreeMap<>();
        Map<String, Integer> map1 = new TreeMap<>();
        List<String> surnames = new ArrayList<>();

        int n = inputReader.nextInt();
        int q = inputReader.nextInt();

        for (int i = 0; i < n; ++i) {
            String s = inputReader.next();
            surnames.add(s);
            map1.put(s, i + 1);
        }

        Collections.sort(surnames);

        for (int i = 0; i < n; ++i) {
            String cur = "";

            for (char j = 0; j < surnames.get(i).length(); ++j) {
                cur += surnames.get(i).charAt(j);

                if (!map.containsKey(cur)) {
                   map.put(cur, new Pair(surnames.get(i), i + 1));
                }
            }
        }

        for (int i = 0; i < q; ++i) {
            int index = inputReader.nextInt();
            String prefix = inputReader.next();

            int result = map.get(prefix).getIndex() + index - 1;

            if (surnames.get(result - 1).startsWith(prefix)) {
                printWriter.println(map1.get(surnames.get(result - 1)));
            } else {
                printWriter.println(-1);
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