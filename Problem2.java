import java.util.*;

public class Problem2 {

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            long x = (long) 1e18;
            Map<Long, Integer> freq = new HashMap<>();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
                x = Math.min(x, arr[i]);
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }

            if (freq.get(x) >= 2) {
                System.out.println("Yes");
                continue;
            }

            List<Long> multiples = new ArrayList<>();
            for (long num : arr) {
                if (num % x == 0 && num != x) {
                    multiples.add(num);
                }
            }

            if (multiples.size() < 2) {
                System.out.println("No");
                continue;
            }

            List<Long> divided = new ArrayList<>();
            for (long num : multiples) {
                divided.add(num / x);
            }

            long overallGcd = divided.get(0);
            for (int i = 1; i < divided.size(); i++) {
                overallGcd = gcd(overallGcd, divided.get(i));
                if (overallGcd == 1) {
                    break;
                }
            }

            if (overallGcd == 1) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
