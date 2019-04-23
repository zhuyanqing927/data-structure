package com.yankie.study.linearity.stack;

import com.yankie.study.linearity.array.Array;

/**
 * 底层基于动态数组实现的栈
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> arrayStack;

    public ArrayStack(int capacity) {
        arrayStack = new Array<E>(capacity);
    }

    public ArrayStack() {
        this(10);
    }

    /**
     * 入栈
     */
    public void push(E e) {
        arrayStack.addLast(e);
    }

    /**
     * 出栈
     */
    public E pop() {
        return arrayStack.removeLast();
    }

    /**
     * 查询栈顶元素
     */
    public E peek() {
        return arrayStack.getLast();
    }

    /**
     * 得到栈中元素个数
     */
    public int getSize() {
        return arrayStack.getSize();
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return arrayStack.isEmpty();
    }

    /**
     * 获取栈的容积：只有基于动态数组实现的栈才有该方法
     */
    public int getCapacity() {
        return arrayStack.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:");
        sb.append("[");
        for (int i = 0; i < arrayStack.getSize(); i++) {
            sb.append(arrayStack.get(i));
            if (i != arrayStack.getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
