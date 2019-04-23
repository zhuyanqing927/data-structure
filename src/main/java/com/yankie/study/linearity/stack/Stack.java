package com.yankie.study.linearity.stack;

/**
 * 自定义栈
 * 栈是一种后进先出的数据结构 LIFO
 */
public interface Stack<E> {

    /**
     * 入栈
     */
    void push(E e);

    /**
     * 出栈
     */
    E pop();

    /**
     * 获取栈顶的元素
     */
    E peek();

    /**
     * 获取栈中元素个数
     */
    int getSize();

    /**
     * 判断栈是否为空
     */
    boolean isEmpty();
}
