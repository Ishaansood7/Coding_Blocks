import java.util.*;

public class PlacingCows {

    // Check if we can place all cows with minimum distance = dist
    public static boolean canPlace(int[] stalls, int cows, int dist) {

        int count = 1;              // first cow placed
        int lastPos = stalls[0]; //Last position of cow placed

        for(int i = 1; i < stalls.length; i++) {

            if(stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
            }

            if(count >= cows) return true;
        }

        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(canPlace(stalls, cows, mid)) {
                ans = mid;          // possible
                low = mid + 1;      // try bigger distance
            } else {
                high = mid - 1;     // reduce distance
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {

            int n = sc.nextInt();
            int cows = sc.nextInt();

            int[] stalls = new int[n];

            for(int i = 0; i < n; i++) {
                stalls[i] = sc.nextInt();
            }

            System.out.println(aggressiveCows(stalls, cows));
        }
    }
}
