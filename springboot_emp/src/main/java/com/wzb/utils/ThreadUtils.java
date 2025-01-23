package com.wzb.utils;

/**
 * 线程工具
 */
public class ThreadUtils {

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    /**
     * 通过ThreadLocal设置当前线程的用户id
     * @param userId 用户id
     */
    public static void setCurrentId(Integer userId) {
        CURRENT_LOCAL.set(userId);
    }

    /**
     * 通过ThreadLocal获取当前线程的用户id
     * @return 用户id
     */
    public static Integer getCurrentId() {
        return CURRENT_LOCAL.get();
    }

    /**
     * 清空线程的存储空间
     */
    public static void remove() {
        CURRENT_LOCAL.remove();
    }
}
