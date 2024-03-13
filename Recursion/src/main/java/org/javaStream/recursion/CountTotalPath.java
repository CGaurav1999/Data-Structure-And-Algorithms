package org.javaStream.recursion;

public class CountTotalPath {
    int[][] arr;
    private int solve(int m,int n){
        if(m==1 && n==1){
            return 1;
        }
        if(arr[m][n]!=0){
            return arr[m][n];
        }
        int total = 0;
        if(m-1>=1)
            total = arr[m-1][n] = solve(m-1,n);

        if(n-1>=1){
            total += arr[m][n-1] = solve(m,n-1);
        }
        return arr[m][n] = total;
    }
    public int uniquePaths(int m, int n) {
        arr=new int[m+1][n+1];
        return solve(m,n);
        // int[][] grid = new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0){
        //             grid[i][j]=1;
        //         }else if(i==0){
        //             grid[i][j]=grid[i][j-1];
        //         }else if(j==0){
        //             grid[i][j]=grid[i-1][j];
        //         }else{
        //             grid[i][j]=grid[i-1][j]+grid[i][j-1];
        //         }
        //     }
        // }
        // return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        CountTotalPath obj = new CountTotalPath();
        System.out.println(obj.uniquePaths(3,4));
    }
}
