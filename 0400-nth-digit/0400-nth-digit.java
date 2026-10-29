class Solution {
    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        long number = 9;
        long increment = 1;
        int digits = 1;

        while (number + 9 * increment * 10 * (digits + 1) < n) {
            digits++;
            increment *= 10;
            number += 9 * increment * digits;
        }

        long currentValue = (long) Math.pow(10, digits)
                          + (n - number - 1) / (digits + 1);

        String s = String.valueOf(currentValue);
        System.out.println(s);
        return (int)(s.charAt((int) ((n - number - 1) % (digits + 1))) - '0');
    }
}