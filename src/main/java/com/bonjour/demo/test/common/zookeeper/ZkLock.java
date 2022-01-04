package com.bonjour.demo.test.common.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * zookeeper分布式锁
 * @authur tc
 * @date 2021/11/23 15:15
 */
public class ZkLock implements Lock {

    /**
     * zookeeper 分布式锁实现原理 首先创建锁的根结点，当有客户端尝试加锁的时候，
     * 会在根结点下面创建个临时顺序结点，然后获取根结点下的结点，判断创建的结点是不是最小的
     * 如果是最小的就加锁成功，如果不是最小的，则会监听自己的上一个结点，如果上一个结点释放了锁（删除了结点），
     * 则会触发监听事件，依次排队的客户端就会再次获取锁
     */

    // 计数器，用于加锁失败时，阻塞
    private static CountDownLatch cdl = new CountDownLatch(1);

    // ZooKeeper服务器的IP端口
    private static final String IP_PORT = "127.0.0.1:2181";

    // 锁的根路径
    private static final String ROOT_NODE = "/Lock";

    // 上一个节点的路径
    private volatile String beforePath;

    // 当前上锁的节点路径
    private volatile String currPath;

    //创建ZooKeeper客户端
    private ZkClient zkClient = new ZkClient(IP_PORT);

    public ZkLock() {
        // 判断是否存在根节点
        if (!zkClient.exists(ROOT_NODE)) {
            // 不存在则创建
            zkClient.createPersistent(ROOT_NODE);
        }
    }

    @Override
    public void lock() {
        if (tryLock()) {
            System.out.println("加锁成功！！");
        } else {
            // 尝试加锁失败，进入等待 监听
            waitForLock();
            // 再次尝试加锁
            lock();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    //等待上锁，加锁失败进入阻塞，监听上一个节点
    private void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            //监听节点更新事件
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            //监听节点被删除事件
            @Override
            public void handleDataDeleted(String s) throws Exception {
                //解除阻塞
                cdl.countDown();
            }
        };
        // 监听上一个节点
        this.zkClient.subscribeDataChanges(beforePath, listener);
        //判断上一个节点是否存在
        if (zkClient.exists(beforePath)) {
            //上一个节点存在
            try {
                System.out.println("加锁失败 等待");
                //加锁失败，阻塞等待
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(beforePath, listener);
    }

    @Override
    public synchronized boolean tryLock() {

        // 第一次就进来创建自己的临时节点
        if (StringUtils.isBlank(currPath)) {
            currPath = zkClient.createEphemeralSequential(ROOT_NODE + "/", "lock");
        }

        // 对节点排序
        List<String> children = zkClient.getChildren(ROOT_NODE);
        Collections.sort(children);

        // 当前的是最小节点就返回加锁成功
        if (currPath.equals(ROOT_NODE + "/" + children.get(0))) {
            return true;
        } else {
            // 不是最小节点 就找到自己的前一个 依次类推 释放也是一样
            int beforePathIndex = Collections.binarySearch(children, currPath.substring(ROOT_NODE.length() + 1)) - 1;
            beforePath = ROOT_NODE + "/" + children.get(beforePathIndex);
            //返回加锁失败
            return false;
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        //删除节点并关闭客户端
        zkClient.delete(currPath);
        zkClient.close();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
