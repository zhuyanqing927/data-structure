package com.yankie.study.linearity.queue;

/**
 * 循环队列
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;  //队列首，尾指针
    private int size;

    public LoopQueue(int capacity) {
        //实际容量要比指定容量多1，刻意浪费一个空间来实现循环队列
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 入队
     */
    public void enqueue(E e) {
        //判断循环队列是否满的规则是：（队尾+1）% 容积 = 零
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 扩容
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     */
    public E dequeue() {
        //先判断队列是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        //获取出队元素值
        E returnResult = data[front];

        //触发垃圾回收，防止空引用
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        //触发缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return returnResult;
    }

    /**
     * 获取队首元素
     */
    public E getFront() {
        //先判断队列是否为空
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    /**
     * 获取队列中元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return size == 0 || front == tail;
    }

    /**
     * 获取队列的容积
     * 因为构造队列的时候有意的+1，所以实际的容量需要-1
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue:size = %d,capacity = %d \n", size, getCapacity()));
        sb.append("front [");

        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }

        sb.append("] tail");
        return sb.toString();
    }
}
