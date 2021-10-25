package com.bonjour.demo.test.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @authur tc
 * @date 2021/10/12 14:45
 */
public class Test {


    // 回文数正反都一样的整数  如121
    public static boolean sameNum(int num) {
        // 为负数直接返回为空
        if (num < 0) {
            return false;
        }
        // 反转字符串
        String s = String.valueOf(num);
        StringBuilder stringBuilder = new StringBuilder(s);
        String re = stringBuilder.reverse().toString();
        return re.equals(s);
    }


    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     */
    public static List<List<Integer>> threeNums(int[] nums) {
        long startTime = System.currentTimeMillis();
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (nums[i] ==0 && nums[j] ==0 && nums[k] ==0) {
                            System.out.println(nums[i]);
                        }
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        if (!isSame(list, list1)) {
                            list.add(list1);
                        }
                    }
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 60*60);
        return list;
    }
    // 判断list中的元素是否相等
    public static boolean isSame(List<List<Integer>> list, List<Integer> co) {
        for (List<Integer> integers : list) {
            if (co.containsAll(integers)) {
                return true;
            }
        }
        return false;
    }

    /**
     *给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *2->abc 3->def 4->ghi 5->jkl 6->mno 7->pqrs 8->tuv 9->wxyz
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() > 4 || digits.contains("1")) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();

        return result;
    }
    public static List<String> returnList(String num) {
        List<String> list = new ArrayList<>();
        if ("2".equals(num)) {
            Collections.addAll(list, "a", "b", "c");
        }
        if ("3".equals(num)) {
            Collections.addAll(list, "d", "e", "f");
        }
        if ("4".equals(num)) {
            Collections.addAll(list, "g", "h", "i");
        }
        if ("5".equals(num)) {
            Collections.addAll(list, "j", "k", "l");
        }
        if ("6".equals(num)) {
            Collections.addAll(list, "m", "n", "o");
        }
        if ("7".equals(num)) {
            Collections.addAll(list, "p", "q", "r", "s");
        }
        if ("8".equals(num)) {
            Collections.addAll(list, "t", "u", "v");
        }
        if ("9".equals(num)) {
            Collections.addAll(list, "w", "x", "y", "z");
        }
        return list;
    }

    /**
     * 链表
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = {};
//        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
//        int[] nums = {3,0,-2,-1,1,2};
        int num = 123;
        // [[-2,-1,3],[-2,0,2],[-1,0,1]]
        List<Integer> list = new ArrayList<>();
        list.add(-4);
        list.add(0);
        list.add(4);
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(0);
        list1.add(0);
//        System.out.println(list1.containsAll(list));
//        System.out.println(threeNums(nums));

        String s = "234";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        System.out.println(chars);
    }

}
