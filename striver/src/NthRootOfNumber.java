public class NthRootOfNumber {

    //TC: O(m * log n) // logn for calculating pow
    public static int findRootNaive(int n, int m){
        for(int i = 1; i <= m; i++){
            if(pow(i, n) == m) return i;
            else if(pow(i, n) > m) break;
        }

        return -1;
    }

    public static int pow(int x, int n){
        int pow = x;
        for(int i = 1; i < n; i++){
            pow = pow * x;
        }

        return pow;
    }

    //TC: O(logm * logn)
    public static int findRoot(int n, int m){
        int start = 1;
        int end = m;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if(pow(mid, n) == m) return mid;

            if(pow(mid, n) < m) start = mid + 1;
            else end = mid -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 69;

        System.out.println(findRoot(n,m));
    }
}
