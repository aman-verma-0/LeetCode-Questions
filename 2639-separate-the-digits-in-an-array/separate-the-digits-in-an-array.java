// class Solution {
//     public int[] separateDigits(int[] nums) {
//         int n=nums.length;
//         List<Integer> ans=new ArrayList<>();
//         for(int num:nums){
//             if(num/10==0) ans.add(num);
//             else addDigitWise(num,ans);
//         }
//         int ansLen=ans.size();
//         int[]arr=new int[ansLen];

//         for(int i=0;i<ansLen;i++){
//             arr[i]=ans.get(i);
//         }
//         return arr;
        
//     }
//     public void addDigitWise(int num,List<Integer>ans){
//         List<Integer> temp=new ArrayList<>();
//         while(num>0){
//             int rem=num%10;
//             temp.add(rem);
//             rem=rem/10;
//         }
//         for(int i=temp.size()-1;i>=0;i--){
//             ans.add(temp.get(i));
//         }

//     }
// }
class Solution {

    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int x : nums) {
            List<Integer> tmp = new ArrayList<>();
            while (x > 0) {
                tmp.add(x % 10);
                x /= 10;
            }
            for (int i = tmp.size() - 1; i >= 0; i--) {
                res.add(tmp.get(i));
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}