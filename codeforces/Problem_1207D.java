import java.util.*;

public class Problem_1207D {
    final static long PRIME = 998244353;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        List<Pair> list = new ArrayList<>();
        HashMap<Integer, Integer> firstMap = new HashMap<>();
        HashMap<Integer, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = input.nextInt(), b = input.nextInt();
            list.add(new Pair(a, b));
            firstMap.put(a, firstMap.get(a) == null ? 1 : firstMap.get(a) + 1);
            secondMap.put(b, secondMap.get(b) == null ? 1 : secondMap.get(b) + 1);
        }

        long numberOfPermutations = factorial(n);
        numberOfPermutations = (numberOfPermutations + PRIME - getNumberOfPermutations(firstMap.values())) % PRIME;
        numberOfPermutations = (numberOfPermutations + PRIME - getNumberOfPermutations(secondMap.values())) % PRIME;

        Collections.sort(list);

        int count = 1;
        long p = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).b > list.get(i).b) {
                p = 0;
                break;
            }
            if (list.get(i - 1).a == list.get(i).a && list.get(i - 1).b == list.get(i).b) {
                count++;
            } else {
                p = (p * factorial(count)) % PRIME;
                count = 1;
            }
        }
        p = (p * factorial(count)) % PRIME;

        numberOfPermutations = (numberOfPermutations + PRIME + p) % PRIME;

        System.out.println(numberOfPermutations);
        input.close();
    }

    static long getNumberOfPermutations(Collection<Integer> values) {
        long answer = 1;

        for (Integer value : values)
            answer = (answer * factorial(value)) % PRIME;

        return answer;
    }

    static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++)
            fact = (fact * i) % PRIME;

        return fact;
    }

    static class Pair implements Comparable<Pair> {
        public long a, b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {
            if (a > p.a)
                return 1;
            if (a < p.a)
                return -1;

            if (b > p.b)
                return 1;
            if (b < p.b)
                return -1;

            return 0;
        }
    }
}