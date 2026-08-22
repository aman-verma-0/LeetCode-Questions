class Solution {
    public boolean checkDivisibility(int n) {
        int sumOfD=sumOfDigit(n);
        int prodOfD=productOfDigit(n);
        int sum=sumOfD+prodOfD;
        return (n%sum==0);

        
    }
    public int sumOfDigit(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public int productOfDigit(int num){
        int prod=1;
        while(num!=0){
            int rem=num%10;
            prod*=rem;
            num=num/10;

        }
        return prod;
    }
    
}