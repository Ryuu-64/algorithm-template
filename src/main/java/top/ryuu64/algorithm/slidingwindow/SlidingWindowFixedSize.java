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
        int value = 0;
        // 示例：这里用 max 作为结果
        int result = Integer.MIN_VALUE;

        for (int right = 0; right < nums.length; right++) {
            // 1. 处理右端
            value += nums[right];

            // 2. 窗口未形成
            if (right < k - 1) {
                continue;
            }

            // 3️. 更新结果
            result = updateResult(result, value);

            // 4. 处理右端
            int left = right - k + 1;
            value -= nums[left];
        }

        return result;
    }

    private static int updateResult(int result, int value) {
        // 默认示例：取最大值
        return Math.max(result, value);
    }
}
