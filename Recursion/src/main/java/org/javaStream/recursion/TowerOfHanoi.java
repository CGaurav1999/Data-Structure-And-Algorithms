package org.javaStream.recursion;

//https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class TowerOfHanoi {
        static int cnt;
        private void help(int n,int from,int to, int aux){
            if(n==0) return;
            help(n-1,from,aux,to);
            System.out.println("move disk " + n + " from rod " + from + " to rod " + to);
            cnt++;
            help(n-1,aux,to,from);
        }

        public long toh(int n, int from, int to, int aux) {
            // Your code here
            cnt = 0;
            help(n,from,to,aux);
            return cnt;

        }
    public static void main(String[] args) {
        TowerOfHanoi obj = new TowerOfHanoi();
        System.out.println(obj.toh(3,1,2,3));
    }
}
