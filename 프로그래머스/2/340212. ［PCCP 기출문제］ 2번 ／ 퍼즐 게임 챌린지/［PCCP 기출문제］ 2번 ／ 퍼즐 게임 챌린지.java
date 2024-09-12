class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int N = diffs.length;
        int prev_time = 0;
        int left = 0;
        int right = 100_000;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            long sum = 0;
            prev_time = 0;
            for (int i = 0; i < N; i++) {
                if (diffs[i] <= mid) sum += times[i];
                else sum += (times[i] + prev_time) * (diffs[i] - mid) + times[i];
                prev_time = times[i];
            }
            if (sum > limit) left = mid;
            else right = mid;
        }
        return right;
    }
}