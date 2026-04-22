class Solution {
    public int maxDistance(int[] colors) {

        int n = colors.length;
        int ans = 0;

        // Compare with first element
        for(int i = n - 1; i >= 0; i--) {
            if(colors[i] != colors[0]) {
                ans = i;
                break;
            }
        }

        // Compare with last element
        for(int j = 0; j < n; j++) {
            if(colors[j] != colors[n - 1]) {
                ans = Math.max(ans, n - j - 1);
                break;
            }
        }

        return ans;
    }
}