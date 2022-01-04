package com.bonjour.demo.test.background.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bonjour.demo.test.background.mapper.GoodsMapper;
import com.bonjour.demo.test.background.mapper.UserMapper;
import com.bonjour.demo.test.common.entity.Goods;
import com.bonjour.demo.test.common.entity.User;
import com.bonjour.demo.test.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @authur tc
 * @date 2021/9/28 14:11
 */
@Service
public class TestServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements TestService{

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    UserMapper userMapper;

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public List<User> getUser() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getId, "121456456");
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        return list;
    }

    @Override
    @Transactional
    public void insert() {
        List<Goods> list = new ArrayList<>();
//        for (int i = 2; i < 10002; i++) {
//            Goods goods = new Goods();
//            goods.setId((long) i);
//            goods.setName("iphone" + i);
//            goods.setIsShelf("0");
//            goods.setAddTime(new Date());
//            list.add(goods);
//        }
//        System.out.println("--------------------------------start");
//        long startTime = System.currentTimeMillis();    //获取开始时间
//        this.saveBatch(list, 10000);
//        System.out.println("-------------------------------end");
//        long endTime = System.currentTimeMillis();    //获取结束时间
//
//        System.out.println("mybatis plus 程序运行时间：" + (endTime - startTime) + "ms");
        ApplicationContext applicationContext = null;
        String pro = applicationContext.getEnvironment().getActiveProfiles()[0];
        System.out.println(pro);
    }

    public static void main(String[] args) {
//        List<User> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.setId(String.valueOf(i));
//            user.setNickName("chery" + i);
//            user.setPhone("12345678" + i);
//            list.add(user);
//        }
//        List<User> last = list.stream().filter(item -> !"chery1".equals(item.getNickName())).collect(Collectors.toList());
//        System.out.println(last);
//        List<User> first = list.stream().distinct().collect(Collectors.toList());
//        System.out.println(calculateAge("19621003"));
        User user1 = new User();
        user1.setId("1");
        User user2 = new User();
        user2.setId("1");
        System.out.println(user1.equals(user2));
        System.out.println(user1 == user2);
        StringBuilder stringBuilder = new StringBuilder("hello");
        stringBuilder.append(" world!");
        System.out.println(stringBuilder);
        StringBuffer stringBuffer = new StringBuffer("hello");   // 线程安全
//        ApplicationContext applicationContext = null;
//        String pro = applicationContext.getEnvironment().getActiveProfiles()[0];
//        System.out.println(pro);
        AtomicInteger integer = new AtomicInteger(1);
    }

    /**
     * 计算年龄 是否大于 59岁11个月
     * @param idNumber
     * @return
     */
    public static boolean calculateAge(String idNumber) {
        // 获取当期年月日及输入的年月日
        Calendar cal = Calendar.getInstance();
        // 输入的年
        int inputYear = Integer.parseInt((idNumber.subSequence(0, 4).toString()));
        // 输入的月
        int inputMonth = Integer.parseInt((idNumber.subSequence(4, 6).toString()));
        // 输入的日
        int inputDay = Integer.parseInt((idNumber.subSequence(6, 8).toString()));
        // 当前的年
        int currentYear = cal.get(Calendar.YEAR);
        // 当前的月
        int currentMonth = cal.get(Calendar.MONDAY) + 1;
        // 当前的日
        int currentDay = cal.get(Calendar.DAY_OF_MONTH);
        int age = currentYear - inputYear;
        if (inputMonth > currentMonth || (inputMonth == currentMonth && inputDay > currentDay)) {
            age--;
        }
        System.out.println(age);
        // 年龄大于60
        if (age >= 60) {
            return true;
            // 年龄小于59
        } else if (age < 59) {
            return false;
            // 小于11个月
        } else if (currentMonth - inputMonth > 1) {
            return false;
        } else {
            // 当前日小于出生日
            return currentDay - inputDay <= 0;
        }
    }

}
