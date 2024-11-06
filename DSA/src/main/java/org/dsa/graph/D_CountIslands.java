package org.dsa.graph;

public class D_CountIslands {
    public void islands(int i,int j,char[][] grid){

        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }

        grid[i][j]='0';

        islands(i+1,j,grid);
        islands(i-1,j,grid);
        islands(i,j-1,grid);
        islands(i,j+1,grid);
        islands(i-1,j-1,grid);
        islands(i-1,j+1,grid);
        islands(i+1,j-1,grid);
        islands(i+1,j+1,grid);

    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    islands(i,j,grid);
                }
            }
        }
        return count;
    }
}
