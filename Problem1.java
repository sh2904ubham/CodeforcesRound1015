import java.util.Scanner;

class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();
        while (t-- > 0) {
            long n = sc.nextLong();
            if (n % 2 != 0) {
                long[] answer = new long[(int) n + 1];
                for (int i = 1; i <= n; i++) {
                    answer[i] = i - 1;
                }
                answer[1] = n;

                for (int i = 1; i <= n; i++) {
                    System.out.print(answer[i] + " ");
                }
            } else {
                System.out.print("-1");
            }
            System.out.println();
        }

    }
}
