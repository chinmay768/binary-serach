public class BinarySearch {

    public static int binarySearchIterative(int[] arr, int target){
        int n = arr.length;
        if(n == 0) return -1;

        int left = 0;
        int right = n - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int left, int right){
        if(left > right) return -1;

        int mid = left + (right - left) / 2;

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] < target){
            return binarySearchRecursive(arr, target, mid + 1, right);
        }else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }



    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
//        int ind = binarySearchIterative(a, target);
        int ind = binarySearchRecursive(a, target, 0, a.length - 1);
        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}
