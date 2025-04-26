public class RowWithMaximumOnes {

    public static int rowWithMax1Naive(int[][] matrix){
        int maxRowIdx = -1;
        int maxCount = 0;
        for(int i = 0; i < matrix.length; i++){
            int currCount = 0;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1) currCount++;
            }
            if(currCount > maxCount) {
                maxCount = currCount;
                maxRowIdx = i;
            }
        }

        return maxRowIdx;
    }

    public static void main(String[] args) {

    }
}
