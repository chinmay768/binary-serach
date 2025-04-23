import java.util.Arrays;

public class BookAllocationProblem {

    public static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    //TC O(sum - max) * O(n)
    public static int allocateBooksNaive(int[] arr, int students){
        if(students > arr.length) return -1;

        int minPages = findMax(arr); // Bc each student must be able to get any book
        int maxPages = Arrays.stream(arr).sum(); // At max all pages

        for(int i = minPages; i <= maxPages; i++){
            if(possibleStudents(arr, i) == students) return i;
        }
        return -1;
    }

    public static int allocateBooks(int[] arr, int students){
        int low = findMax(arr);
        int high = Arrays.stream(arr).sum();

        int res = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            int numOfStudents = possibleStudents(arr, mid);
            if(numOfStudents == students) {
                high = mid - 1;
                res = mid;
            }else if(numOfStudents < students){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return res;
    }

    public static int possibleStudents(int[] arr, int capacity){
        int students = 1;
        int currPages = 0;
        for(int i = 0; i < arr.length; i++){
            if(currPages + arr[i] <= capacity) {
                currPages += arr[i];
            }else{
                students++;
                currPages = arr[i];
            }
        }
        return students;
    }

    public static void main(String[] args) {
//        Each student gets at least one book.
//        Each book should be allocated to only one student.
//        Book allocation should be in a contiguous manner.
//        You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
//        If the allocation of books is not possible. return -1
        int[] arr = {25, 46, 28, 49, 24};
        int students = 4;

        System.out.println(allocateBooks(arr, students));
    }
}
