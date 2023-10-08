package src;

public class Lee74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int start=0;
        int end = m*n-1;

        while(start<=end){
            int mid = start+ (end-start)/2;
            int midMatrix = matrix[mid/n][mid%n];
            if(midMatrix==target){
                return true;
            }else if(midMatrix>target){
                end=mid-1;
            }else if(midMatrix<target){
                start=mid+1;
            }
        }
        return false;
    }
}
