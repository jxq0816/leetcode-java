package no220_containsNearbyAlmostDuplicate;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    //k:下标差值
    //t:val差值
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<Long, Long>();
        //桶的大小为t+1
        long w = (long) t + 1;
        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);
            //我们首先检查 x 所属于的桶是否已经存在元素,如果存在，那么我们就找到了一对符合条件的元素
            if (map.containsKey(id)) {
                return true;
            }
            //检查左侧相邻的桶内是否存在符合条件的元素
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }
            //检查右侧相邻的桶内是否存在符合条件的元素
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }
            //建立目标桶
            map.put(id, (long) nums[i]);
            //删除下标范围不在 [max(0,i−k),i) 内的桶
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }
    //我们将int范围内的每一个整数x表示为x=(t+1)×a+b(0≤b≤t) 的形式，这样x即归属于编号为a的桶。a=(x-b)/(t+1)
    //因为一个桶内至多只会有一个元素，所以我们使用哈希表实现即可。
    public long getID(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }

    public static void main(String[] args) {
        //int[] nums={1,5,9,1,5,9};
        int[] nums={-2147483648,2147483647};
        Solution2 solution=new Solution2();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums,1,1));
    }
}
