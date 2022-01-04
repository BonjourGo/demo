package com.bonjour.demo.test.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @authur tc
 * @date 2021/12/14 23:11
 */
public class Money {

    private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$");
    private static final char[] RMB_NUMS = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final String[] UNITS1 = {"元", "角", "分", "整"};
    private static final String[] UNITS2 = {"", "拾", "佰", "仟"};
    private static final String[] UNITS3 = {"", "万", "亿"};

    public static void main(String[] args) {
        System.out.println(numberConvertAmount("100500.32"));

    }

    /**
     * 将金额（整数部分等于或少于 12 位，小数部分 2 位）转换为中文大写形式.
     *
     * @param amount 金额数字
     * @return 中文大写
     * @throws IllegalArgumentException
     */
    public static String numberConvertAmount(String amount) throws IllegalArgumentException {
        // 去掉分隔符
        amount = amount.replace(",", "");
        // 验证金额正确性
        if (amount.equals("0.00")) {
            throw new IllegalArgumentException("金额不能为零.");
        }
        Matcher matcher = AMOUNT_PATTERN.matcher(amount);
        if (!matcher.find()) {
            throw new IllegalArgumentException("输入金额有误.");
        }

        String integer = matcher.group(1); // 整数部分
        String fraction = matcher.group(2); // 小数部分

        String result = "";
        if (!integer.equals("0")) {
            result += integerToRmb(integer) + UNITS1[0]; // 整数部分
        }
        if (fraction.equals("00")) {
            result += UNITS1[3]; // 添加[整]
        } else if (fraction.startsWith("0") && integer.equals("0")) {
            result += fractionToRmb(fraction).substring(1); // 去掉分前面的[零]
        } else {
            result += fractionToRmb(fraction); // 小数部分
        }

        return result;
    }

    // 将金额小数部分转换为中文大写
    private static String fractionToRmb(String fraction) {
        char jiao = fraction.charAt(0); // 角
        char fen = fraction.charAt(1); // 分
        return (RMB_NUMS[jiao - '0'] + (jiao > '0' ? UNITS1[1] : ""))
                + (fen > '0' ? RMB_NUMS[fen - '0'] + UNITS1[2] : "");
    }

    // 将金额整数部分转换为中文大写
    private static String integerToRmb(String integer) {
        StringBuilder buffer = new StringBuilder();
        // 从个位数开始转换
        int i, j;
        for (i = integer.length() - 1, j = 0; i >= 0; i--, j++) {
            char n = integer.charAt(i);
            if (n == '0') {
                // 当 n 是 0 且 n 的右边一位不是 0 时，插入[零]
                if (i < integer.length() - 1 && integer.charAt(i + 1) != '0') {
                    buffer.append(RMB_NUMS[0]);
                }
                // 插入[万]或者[亿]
                if (j % 4 == 0) {
                    if (i > 0 && integer.charAt(i - 1) != '0' || i > 1 && integer.charAt(i - 2) != '0'
                            || i > 2 && integer.charAt(i - 3) != '0') {
                        buffer.append(UNITS3[j / 4]);
                    }
                }
            } else {
                if (j % 4 == 0) {
                    buffer.append(UNITS3[j / 4]); // 插入[万]或者[亿]
                }
                buffer.append(UNITS2[j % 4]); // 插入[拾]、[佰]或[仟]
                buffer.append(RMB_NUMS[n - '0']); // 插入数字
            }
        }
        return buffer.reverse().toString();
    }
}
