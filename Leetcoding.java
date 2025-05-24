import java.util.*;

public class PrimeSubstringSum {

    // Check if a number is prime
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int sumOfLargest3Primes(String s) {
        Set<Integer> primeSet = new HashSet<>();

        // Generate all substrings and check if they're prime
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                int num = Integer.parseInt(sub);  // automatically ignores leading zeros
                if (isPrime(num)) {
                    primeSet.add(num);
                }
            }
        }

        // Get top 3 largest primes
        List<Integer> primes = new ArrayList<>(primeSet);
        Collections.sort(primes, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < Math.min(3, primes.size()); i++) {
            sum += primes.get(i);
        }

        return sum;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(sumOfLargest3Primes("12234")); // Output: 1469
        System.out.println(sumOfLargest3Primes("111"));   // Output: 11
    }
}
