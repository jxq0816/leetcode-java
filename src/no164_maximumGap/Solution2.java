package no164_maximumGap;

import java.util.Arrays;

public class Solution2 {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        // 找出最大值和最小值 为了方便后面确定桶的数量
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        // 确定桶的间距
        int d = Math.max(1, (maxVal - minVal) / (n - 1));
        // 确定桶的个数
        int bucketSize = (maxVal - minVal) / d + 1;
        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; ++i) {
            // 存储 (桶内最小值，桶内最大值) 对， (-1, -1) 表示该桶是空的
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < n; i++) {
            //找到每一个值所对应桶的索引
            int idx = (nums[i] - minVal) / d;
            //该桶是空的
            if (bucket[idx][0] == -1) {
                //最大值和最小值都设置为nums[i]
                bucket[idx][0] = bucket[idx][1] = nums[i];
            } else {
                // 更新每个桶的数据
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }
        //ret表示桶之间最大的差距
        int ret = 0;
        //preMax 表示前一个桶的最大值
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            //表示某一个桶为空
            if (bucket[i][0] == -1) {
                continue;
            }
            //但凡某一个桶不为空，都会在前面的数据中更新掉bucketMax的值
            if (prev != -1) {
                //用后一个桶的最小值减前一个桶的最大值，可以得到最大间距。
                ret = Math.max(ret, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return ret;
    }
}
