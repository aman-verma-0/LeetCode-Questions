class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int n = robot.size();
        int m = factory.length;

        // Expand factories based on capacity
        List<Integer> positions = new ArrayList<>();
        for (int[] f : factory) {
            int pos = f[0];
            int cap = f[1];
            for (int i = 0; i < cap; i++) {
                positions.add(pos);
            }
        }

        int k = positions.size();

        long[][] dp = new long[n + 1][k + 1];

        // Fill with large values
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        // Base case
        for (int j = 0; j <= k; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                // Option 1: skip this factory slot
                dp[i][j] = dp[i][j - 1];

                // Option 2: assign robot i-1 to this factory slot
                if (dp[i - 1][j - 1] != Long.MAX_VALUE) {
                    long cost = Math.abs(robot.get(i - 1) - positions.get(j - 1));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + cost);
                }
            }
        }

        return dp[n][k];
    }
}