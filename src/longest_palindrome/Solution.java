package longest_palindrome;

public class Solution {
    public boolean isPalindrome(char[] charArray, int left, int right){
        while(left<right){
            if(charArray[left]!=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }
        int maxLen=1;
        int begin=0;
        //s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();
        String rs=s.substring(0,1);
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(isPalindrome(charArray,i,j)&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome("bb"));
    }
}
