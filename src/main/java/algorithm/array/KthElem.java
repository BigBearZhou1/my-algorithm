package algorithm.array;

/**
 * 寻找素组中第K个小的数字
 * 本质上是对数组做排序
 * 排序从算法复杂度角度分为两类：O(n^2)和O(nlog2n)
 * O(n^2)代表的有冒泡、选择、插排等算法，容易理解但是复杂度高，一般不会采用
 * O(nlog2n)代表有快排，归并排序，堆排序；其中快排，归并排序涉及到递归对初学者不友好，堆排相对简单，因此本次解题使用小根堆来做
 */
public class KthElem {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8, 12, 1, 33, 4, 18};
        int k = 3;
        System.out.println("K'th smallest element is " + kthSmallest(arr, k));
    }

    public static int kthSmallest(Integer[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int i = 0; i < k; i++) {
            swap(arr, 0, arr.length - i - 1);
            heapfy(arr, 0, arr.length - i - 1);
        }
        return arr[arr.length - k];
    }

    //交换首尾元素后，维持小根堆结构
    private static void heapfy(Integer[] arr, int i, int border) {
        int left = i * 2 + 1;
        while (left < border) {
            int smaller = left + 1 < border && arr[left + 1] < arr[left] ? left + 1 : left;
            if (arr[smaller] < arr[i]) {
                swap(arr, smaller, i);
                i = smaller;
                left = smaller * 2 + 1;
            } else {
                break;
            }
        }
    }

    //形成小根堆
    private static void heapInsert(Integer[] arr, int i) {
        int root = (i - 1) / 2;
        while (root >= 0 && arr[root] > arr[i]) {
            swap(arr, root, i);
            i = root;
            root = (i - 1) / 2;
        }
    }

    public static void swap(Integer[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
