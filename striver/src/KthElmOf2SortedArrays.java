import java.lang.management.MonitorInfo;

public class KthElmOf2SortedArrays {

    public static int kthElm(int[] arr1, int[] arr2, int k){
        int n1 = arr1.length;
        int n2 = arr2.length;

        if(n1 > n2) return kthElm(arr2, arr1, k);

        int low = Math.max(k - n2, 0);
        int high = Math.min(k, n1);

        while (low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;

            // These below conditions handle the case if no elm is selected form arr1

            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            }else if(l1 > r2) {
                high = mid1 - 1;
            }else {
                low = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = {17};
        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.println(kthElm(arr1, arr2, 3));
    }
}
