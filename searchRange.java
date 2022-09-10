class Solution {
    // time complexity: O(log n)
    // space complexity : O(1)
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        if (target < nums[0] || target > nums[nums.length - 1])
            return new int[] { -1, -1 };

        int firstOccurrence = binarySearchFirst(nums, target);
        if (firstOccurrence == -1)
            return new int[] { -1, -1 };
        int lastOccurrence = binarySearchLast(nums, target, firstOccurrence);
        return new int[] { firstOccurrence, lastOccurrence };
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid])
                    return mid;
                return high = mid - 1;
            } else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int bound) {
        int low = bound;
        int n = nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] > nums[mid])
                    return mid;
                return low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }
}