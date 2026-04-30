class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k-= 1;

        while(k > 0) {
            long steps = cntSteps(n, curr, curr+1);

            if(steps <= k) {
                curr+= 1;
                k = k - (int) steps;
            }

            else {
                curr *= 10;
                k-=1;
            }
        }

        return curr;
    }

    public long cntSteps(int n, long head, long tail) {
        long steps = 0;

        while(head <= n) {
            steps+= Math.min(n + 1, tail) - head;
            head*= 10;
            tail*= 10;
        }

        return steps;
    }
}