import java.util.*;

class threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int target = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; //Skipping Duplicate From ith side.

                        }int j = i + 1;
            int k = n - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else //nums[i] + nums[j] + nums[k] == target
                {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    //Skipping Duplicate Elements
                    int a = j;

                    while (j < k && nums[j] == nums[a]) {
                        j++;
                    }

                    a = k;
                    while (j < k && nums[k] == nums[a]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
