package top.ryuu64.algorithm.slidingwindow;

/**
 * <a href="https://leetcode.cn/problems/maximum-average-subarray-i/description/">643. 子数组最大平均数 I</a>
 */
public class SlidingWindowFixedSize {
    /**
     * 定长滑动窗口
     * @param nums 输入数组
     * @param k    窗口大小
     * <p>
     * 我们需要首先移动右端，然后才会移动左端
     * <p>
     * 特别地，第一次移动时，无需移动左端，只移动右端
     * 第一轮 for 右端处理是滑动的第一轮(只移动右端，左端无需移动)，左端是滑动的第二轮（左端开始移动）
     * 第二轮 for 右端处理是滑动的第二轮，左端是滑动的第三轮
     */
    public static int slidingWindowFixedSize(int[] nums, int k) {
        // 结果值（模板示例为寻找最大值）
        int result = Integer.MIN_VALUE;
        // 中间过程值
        int value = 0;
        for (int right = 0; right < nums.length; right++) {
            // 1. 处理右端
            value += nums[right];

            // 2. 窗口未形成
            int nextLeft = right - k + 1;
            if (nextLeft < 0) {
                continue;
            }

            // 3️. 更新结果（模板示例为寻找最大值）
            result = Math.max(value, result);

            // 4. 处理左端
            value -= nums[nextLeft];
        }

        return result;
    }
}
