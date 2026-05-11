class Solution {
    List<Integer> ans=new ArrayList<>();

    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        for(int num:nums){
            if(num/10==0) ans.add(num);
            else addDigitWise(num);
        }
        int ansLen=ans.size();
        int[]arr=new int[ansLen];

        for(int i=0;i<ansLen;i++){
            arr[i]=ans.get(i);
        }
        return arr;
        
    }
    public void addDigitWise(int num){
        List<Integer> temp=new ArrayList<>();
        while(num>0){
            int rem=num%10;
            temp.add(rem);
            num=num/10;
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }

    }
}
