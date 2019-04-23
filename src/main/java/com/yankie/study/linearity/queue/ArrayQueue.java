package com.yankie.study.linearity.queue;

import com.yankie.study.linearity.array.Array;

/**
 * 基于动态数组实现的队列
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> arrayQueue;

    public ArrayQueue(int capacity) {
        arrayQueue = new Array<E>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    /**
     * 入列
     */
    public void enqueue(E e) {
        arrayQueue.addLast(e);
    }

    /**
     * 出列
     */
    public E dequeue() {
        return arrayQueue.removeFirst();
    }

    /**
     * 查询队列中第一个元素
     */
    public E getFront() {
        return arrayQueue.getFirst();
    }

    /**
     * 获取队列中元素个数
     */
    public int getSize() {
        return arrayQueue.getSize();
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return arrayQueue.isEmpty();
    }

    /**
     * 获取队列的容积，只有基于动态数组的实现才有该方法
     */
    public int getCapacity() {
        return arrayQueue.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayQueue");
        sb.append(" front [");
        for (int i = 0; i < arrayQueue.getSize(); i++) {
            sb.append(arrayQueue.get(i));
            if (i != arrayQueue.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
