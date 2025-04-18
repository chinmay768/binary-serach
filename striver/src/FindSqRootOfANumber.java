public class FindSqRootOfANumber {

    public static int findRootNaive(int n){
        int res = 1;
        for(int i = 1; i <= n; i++){
            if(i * i <= n){
                res = i;
            }else break;
        }

        return res;
    }

    public static int findRoot(int n){
        int ans = 1;
        int low = 1;
        int high = n;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 28;
        System.out.println(findRoot(n));
    }
}
