class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int head = -1;
        int tail = 0;
        int ans = 0;
        int[] freq = new int[26];
        int max = 0;

        while (tail < n) {
            while (head + 1 < n && ((head - tail + 2) - Math.max(max, freq[s.charAt(head + 1) - 'A'] + 1) <= k)) {
                head++;
                freq[s.charAt(head) - 'A']++;
                max = Math.max(max, freq[s.charAt(head) - 'A']);
            }

            ans = Math.max(ans, head - tail + 1);

            if (tail <= head) {
                freq[s.charAt(tail) - 'A']--;
                tail++;
            }

            else {
                tail++;
                head = tail - 1;
            }
        }

        return ans;
    }
}