package org.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/
public class NQueens {
    List<List<String>> ansBoard;
    private boolean canPlace(int[][] board,int n,int row,int col){
        int r = row-1;
        int c = col+1;
        while(r>=0 && c<n){
            if(board[r][c]==1){
                return false;
            }
            r--;
            c++;
        }

        r = row-1;
        c=col;
        while(r>=0){
            if(board[r][c]==1){
                return false;
            }
            r--;
        }

        r = row-1;
        c = col-1;
        while(r>=0 && c>=0){
            if(board[r][c]==1){
                return false;
            }
            r--;
            c--;
        }
        return true;
    }
    private void helper(int[][] board,int row,int n){
        if(row == n){
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]==1)
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                li.add(new String(sb));
            }
            ansBoard.add(li);
            return;
        }
        for(int i=0;i<n;i++){
            if(canPlace(board,n,row,i)){
                board[row][i]=1;
                helper(board,row+1,n);
                board[row][i]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        ansBoard = new ArrayList<>();
        int[][] board = new int[n][n];
        helper(board,0,n);
        return ansBoard;
    }
}
