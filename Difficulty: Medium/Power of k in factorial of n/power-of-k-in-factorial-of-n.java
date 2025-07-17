class Solution {
    public int maxKPower(int n, int k) {
        // check if k is prime
        boolean flag = isPrime(k);
        
        if (flag == true) {
            return maxPow(n, k);
        } else {
            List<Integer> factors = PrimeFactor(k);
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for (int fact : factors) {
                map.put(fact, map.getOrDefault(fact, 0) + 1);
            }

            int maxPowResult = Integer.MAX_VALUE;

            // iterate over the map
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int prime = entry.getKey();
                int freq = entry.getValue();

                int pow = maxPow(n, prime);
                maxPowResult = Math.min(maxPowResult, pow / freq);
            }

            return maxPowResult;
        }
    }

    // Method that returns list of prime factors
    public List<Integer> PrimeFactor(int n) {
        List<Integer> list = new ArrayList<>();
        while (n % 2 == 0) {
            list.add(2);
            n /= 2;
        }
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }
        if (n > 2) list.add(n);
        return list;
    }

    // Check if number is prime
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Maximum power of prime k that divides n!
    public int maxPow(int n, int k) {
        int max = 0;
        int denom = k;

        while (n >= denom) {
            max += n / denom;
            denom *= k;
        }

        return max;
    }
}