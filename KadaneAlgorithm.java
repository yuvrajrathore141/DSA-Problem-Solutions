


public class KadaneAlgorithm {

    public int kadaneAlgorithm(int[] n) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i : n) {

            sum += i;

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}

class Main {
    public static void main(String[] args) {

        int[] nums = {-2, -3, 2, -1, 1, 2};

        KadaneAlgorithm sol = new KadaneAlgorithm();

        System.out.println(sol.kadaneAlgorithm(nums));
    }
}
