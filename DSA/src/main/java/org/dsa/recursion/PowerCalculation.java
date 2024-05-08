package org.dsa.recursion;

//https://leetcode.com/problems/powx-n/description/
public class PowerCalculation {
        public double posPow(double x,int n){
            if(n==0) return 1;
            if(n==1) return x;
            double temp = myPow(x,n/2);
            if(n%2==0){
                return temp*temp;
            }else{
                return temp*temp*x;
            }
        }
        public double negPow(double x,int n){
            if(n==0) return 1;
            if(n==-1) return 1/x;
            double temp = myPow(x,n/2);
            if(n%2==0){
                return temp*temp;
            }else{
                return (temp*temp)/x;
            }
        }
        public double myPow(double x, int n) {
            if(n>0) return posPow(x,n);
            return negPow(x,n);
        }

    public static void main(String[] args) {
        PowerCalculation  obj = new PowerCalculation();
        System.out.println(obj.myPow(2,5));
    }

}
