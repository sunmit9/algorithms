/**
 * Created by sunmit9 on 02/04/17.
 *
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 *
 * Given a sorted array consisting of only integers where every element
 * appears twice except for one element which appears once.
 * Find this single element that appears only once.
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Input: [3,3,7,7,10,11,11]
 * Output 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 */
public class NonDuplicateNumber {

    public static void main(String[] args) {
        System.out.println("Non repeating number = " + singleNonDuplicate(new int[]{0,1,1}));
    }

    private static int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0, nums.length-1);
    }

    private static int singleNonDuplicate(int[] nums, int start, int end){
        if(start == end){
            return nums[start];
        }
        int center = (end-start)/2 + start;
        if(center == 0){
            return nums[start];
        } else if(center % 2 == 0){
            //if the center is even,

            // if center number and next number are the same, the non duplicate number is on the right.
            if(nums[center] == nums[center + 1]){
                return singleNonDuplicate(nums, center + 1, end);
            }else{
                // else the number is on the left
                return singleNonDuplicate(nums, start, center );
            }
        }else{
            //if the center is odd,

            // if center number and next number are the same, the non duplicate number is on the left.
            if(nums[center] == nums[center + 1]){
                return singleNonDuplicate(nums, start, center);
            }else{
                // else the number is on the right
                return singleNonDuplicate(nums, center + 1, end);
            }
        }
    }
}


