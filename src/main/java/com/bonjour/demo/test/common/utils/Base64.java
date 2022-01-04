package com.bonjour.demo.test.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * base64转pdf工具类
 * @authur tc
 * @date 2021/12/14 16:39
 */
public class Base64 {

    @Autowired
    private RedisUtils redisUtils;

    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            String str = "";
            while ((s = br.readLine()) != null) {
                str = str + s;
            }
            br.close();
            base64StringToPDF(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        File file = new File("D:/3.txt");
//        txt2String(file);
//        BigDecimal bigDecimal = new BigDecimal("0.00");
//        System.out.println(bigDecimal.multiply(new BigDecimal("-1")));
//        System.out.println(BigDecimal.ZERO);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
//        System.out.println(simpleDateFormat.format(new Date()));
//        System.out.println(getString("aaa"));
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
//        format.format(new Date());
//        DecimalFormat decimalFormat = new DecimalFormat("000000");
//        Object value = "1";
//        System.out.println(decimalFormat.format(value));
        BigDecimal a = new BigDecimal("1.00");
        System.out.println(new BigDecimal("0.00").equals(a));
        BigDecimal b = new BigDecimal("10.00");
        Long a1 = 200L;
        System.out.println(a1*-1);
    }

//    public static String getString(String key) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
//        format.format(new Date());
//        DecimalFormat decimalFormat = new DecimalFormat("000000");
//        String value = .incrId(key).toString();
//        return decimalFormat.format(value);
//    }

    public static void base64StringToPDF(String base64sString) {
        BufferedInputStream bin = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64sString);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            bin = new BufferedInputStream(bais);
            File file = new File("D:/165.pdf");
            fout = new FileOutputStream(file);
            bout = new BufferedOutputStream(fout);
            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            bout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bin.close();
                fout.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
