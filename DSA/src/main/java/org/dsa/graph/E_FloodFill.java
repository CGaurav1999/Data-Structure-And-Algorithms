package org.dsa.graph;

public class E_FloodFill {
    public void fill(int i,int j,int originalColor,int newColor,int[][] image){

        if(i<0 || i>=image.length || j<0 || j>=image[0].length || originalColor != image[i][j]){
            return;
        }

        image[i][j]=newColor;

        fill(i+1,j,originalColor,newColor,image);
        fill(i-1,j,originalColor,newColor,image);
        fill(i,j-1,originalColor,newColor,image);
        fill(i,j+1,originalColor,newColor,image);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if(image[sr][sc] != newColor)
            fill(sr,sc,image[sr][sc],newColor,image);
        return image;

    }
}
