package org.dsa.backtracking;

//https://leetcode.com/problems/check-knight-tour-configuration/description/
public class CheckKNightTourConfiguration {
    public boolean helper(int[][] grid,int i,int j,int cnt,int n){
        if(i>=n || i<0 || j<0 || j>=n){
            return false;
        }
        if(cnt == n*n-1 && grid[i][j]==cnt){
            return true;
        }
        if(grid[i][j] != cnt){
            return false;
        }
        int[] rows = {-1,-2,-2,-1, 1, 2,2,1};
        int[] cols = {2,  1,-1,-2,-2,-1,1,2};
        for(int x=0;x<8;x++){
            if(helper(grid,i+rows[x],j+cols[x],cnt+1,n)){
                return true;
            }
        }
        return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        return helper(grid,0,0,0,grid.length);
    }
}
