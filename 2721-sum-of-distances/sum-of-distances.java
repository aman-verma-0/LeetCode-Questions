class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();

        // same as your code
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // 🔥 process each number group
        for (int num : map.keySet()) {

            List<Integer> list = map.get(num);
            int size = list.size();

            // prefix sum array
            long[] prefix = new long[size];
            prefix[0] = list.get(0);

            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            // compute result for each index
            for (int i = 0; i < size; i++) {

                int index = list.get(i);

                long left = (long)i * list.get(i) - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[size - 1] - prefix[i]) 
                           - (long)(size - i - 1) * list.get(i);

                arr[index] = left + right;
            }
        }

        return arr;
    }
}