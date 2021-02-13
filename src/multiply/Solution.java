package multiply;

public class Solution {
    public String multiply(String num1, String num2) {
        int n1=num1.length();
        int n2=num2.length();
        int[] res=new int[n1+n2];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                int a=num1.charAt(i)-'0';
                int b=num2.charAt(j)-'0';
                int r=a*b;
                r+=res[i+j+1];
                res[i+j+1]=r%10;
                res[i+j]+=r/10;
            }
        }
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<n1+n2;i++){
            if(sb.length()==0&&res[i]==0){
                continue;
            }
            sb.append(res[i]);
        }
        String rs=sb.toString();
        System.out.println(rs);
        if(rs.isEmpty()){
            rs="0";
        }
        return rs;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.multiply("0","0"));
    }
}
