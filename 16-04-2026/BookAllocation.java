import java.util.*;
public class BookAllocation {
    public static int check(int[] nums, int mid, int k) {
        int stCnt = 1;
        int pagesRead = 0;
        for(int i = 0; i < nums.length; i++) {
            if(pagesRead + nums[i] > mid) {
                stCnt++;
                pagesRead = nums[i];
            }
            else {
                pagesRead += nums[i];
            }
        }

        return stCnt <= k ? 1 : 0;

    }

    public static int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int ans = low;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(check(nums,mid,k) == 1) {
                ans = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int student = sc.nextInt();

            int[] nums = new int[n];

            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(splitArray(nums, student));
        }

    }
}