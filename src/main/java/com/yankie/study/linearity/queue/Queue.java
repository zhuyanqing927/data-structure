package com.yankie.study.linearity.queue;

/**
 * 自定义队列
 * 队列是一种先进先出的数据结构 FIFO
 */
public interface Queue<E> {
    /**
     * 入列
     */
    void enqueue(E e);

    /**
     * 出列
     */
    E dequeue();

    /**
     * 队列首位
     */
    E getFront();

    /**
     * 队列元素的个数
     */
    int getSize();

    /**
     * 判断队列是否为空
     */
    boolean isEmpty();
}
