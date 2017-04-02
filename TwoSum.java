import java.util.HashMap;
import java.util.Map;

/**
 *
 * Created by sunmit9 on 30/03/17.
 *
 * https://leetcode.com/problems/two-sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] sol = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(sol[0] + ", " + sol[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i );
            int complement = target - numbers[i+1];
            if (map.containsKey(complement)) {
                result[1] = i + 1;
                result[0] = map.get(complement);
                return result;
            }
        }
        return result;
    }

    public int[] twoSums(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]) - 1;
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }
}
