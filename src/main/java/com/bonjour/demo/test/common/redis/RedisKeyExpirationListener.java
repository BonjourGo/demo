//package com.bonjour.demo.test.common.redis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.Message;
//import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.stereotype.Component;
//
///**
// * redis 过期事件监听类
// * @authur tc
// * @date 2021/11/22 21:19
// */
//@Slf4j
//@Component
//public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
//
//
//    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
//        super(listenerContainer);
//    }
//
//    /**
//     * Redis实现订单多久关闭
//     * 本质是设置过期时间，通过监听Redis过期事件
//     * 完成对定时关闭订单的功能
//     * 需要修改redis.windows.conf配置文件中notify-keyspace-events的值
//     * 默认配置notify-keyspace-events的值为 "" 修改为 notify-keyspace-events Ex 这样便开启了过期事件
//     * @param message
//     * @param pattern
//     */
//    @Override
//    public void onMessage(Message message, byte[] pattern) {
//        log.info("listen start");
//        try {
//            // 获取进入的key
//            String key = message.toString();
//            if (key != null && key.startsWith("order_")) {
//                // 逻辑处理
//                log.info(key + "进入过期时间");
//            }
//        } catch (Exception e) {
//            log.error(e.toString());
//        }
//    }
//}
