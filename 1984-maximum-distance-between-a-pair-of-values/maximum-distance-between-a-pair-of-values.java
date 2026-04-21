class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int ans = 0, tail = 0, head = -1;

        while(tail < n && head < m) {
            while(head + 1 < m && nums1[tail] <= nums2[head + 1]) {
                head++;
            }

            ans = Math.max(ans, head - tail);

            if (tail <= head) {
                tail++;
            }

            else if (tail > head) {
                tail++;
                head = tail - 1;
            }
        }
        return ans;
    }
}