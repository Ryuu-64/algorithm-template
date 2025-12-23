package top.ryuu64.algorithm.slidingwindow;

/**
 * <a href="https://www.geeksforgeeks.org/dsa/window-sliding-technique/">window-sliding-technique</a>
 * <p>
 * 可变长度滑动窗口（Variable Size Sliding Window）
 * <p>
 * 适用场景：
 * - 最短 / 最长子数组
 * - 至多 K 个不同元素
 * - 满足某个条件的连续区间
 */
public class VariableSizeSlidingWindow {
    public static int variableSizeSlidingWindow(int[] nums) {
        int value = 0;
        int left = 0;
        // 中间过程值（如：sum / count / map.size()）
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            // 1. 处理右端（不一定需要）
            value += nums[right];

            // 2. 处理左端，左端收缩窗口（与定长滑动窗口的核心区别）
            while (!windowValid(value)) {
                value -= nums[left];
                left++;
            }

            // 3. 更新结果（窗口此时一定合法）
            result = updateResult(result, left, right, value);
        }

        return result;
    }

    /**
     * 判断当前窗口是否合法
     */
    private static boolean windowValid(int value) {
        // TODO: 根据题目定义合法条件
        // 例：value <= target
        return true;
    }

    /**
     * 更新答案（最长 / 最短 / 最大 / 最小）
     */
    private static int updateResult(int result, int left, int right, int value) {
        // 示例：最长合法子数组
        return Math.max(result, right - left + 1);
    }
}
