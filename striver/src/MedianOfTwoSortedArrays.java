import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    //TC: O(n + m)
    //SC: O(n + m)
    public static double findMedianSortedArraysNaive(int[] nums1, int[] nums2){
        int[] mergedArr = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                mergedArr[k++] = nums1[i++];
            }else {
                mergedArr[k++] = nums2[j++];
            }
        }

        while (i < nums1.length){
            mergedArr[k++] = nums1[i++];
        }

        while (j < nums2.length){
            mergedArr[k++] = nums2[j++];
        }

        int totalLen = mergedArr.length;
        if(totalLen % 2 == 0){
            int mid = totalLen / 2;
            return ((double)mergedArr[mid] + (double) mergedArr[mid - 1]) / 2.0;
        }
        else return mergedArr[totalLen / 2];
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1  = nums1.length;
        int n2 = nums2.length;

        // Do it this way to avoid too many condition handling (like mid1 with nums1 or nums2)
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;

        int leftElements = (n1 + n2) / 2;  // This works for both odd and even lenghts

        while (low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = leftElements - mid1;

            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 1) return Math.min(r1, r2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }else if(l1 > r2){
                high = mid1 - 1;
            }else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3};
        int[] arr2 = {2};

//        int[] arr3 = new int[arr1.length + arr2.length];
//        System.out.println(Arrays.toString(arr3));

        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
