package others;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums){
        int numsSize=nums.length;
        int count=0;//记录删除了多少个数
        if(numsSize == 0){
            return 0;//若长度为0，直接返回
        }

        for(int i=0;i<numsSize-count;i++)
        {
            for(int j=i+1;j<numsSize-count;j++)
            {
                if(nums[j]==nums[i])
                {
                    count++;
                    int t=j;
                    while(t<numsSize-count)
                    {
                        nums[t]=nums[t+1];
                        t++;
                    }
                    j--;//继续循环，删除多次重复的数
                }else{
                    continue;
                }
            }
        }
        return (numsSize-count);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
