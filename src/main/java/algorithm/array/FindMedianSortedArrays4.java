package algorithm.array;

/**
 * 4. 寻找两个正序数组的中位数
 * 核心思想就是找到两个数组中第K个大小的数
 * 两个数组分别取总长度的一半的一半，比较这个中间数，一次可以排除一部分小的数字
 */
public class FindMedianSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 1) {
            return getKthElement(nums1, nums2, (total / 2) + 1);
        } else {
            return (getKthElement(nums1, nums2, (total / 2)) + getKthElement(nums1, nums2, (total / 2) + 1)) / 2.0;
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int idx1 = 0;
        int idx2 = 0;

        while (true) {
            if (idx1 == len1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == len2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }

            int half = k / 2;
            int newIdx1 = Math.min(idx1 + half, len1) - 1;
            int newIdx2 = Math.min(idx2 + half, len2) - 1;
            int val1 = nums1[newIdx1];
            int val2 = nums2[newIdx2];
            if (val1 <= val2) {
                k -= ((newIdx1 - idx1) + 1);
                idx1 = newIdx1 + 1;
            } else {
                k -= ((newIdx2 - idx2) + 1);
                idx2 = newIdx2 + 1;
            }
        }

    }
}
