package com.yankie.study.linearity.array;

/**
 * 自定义数组
 * 同一个数组中，只能存放相同类型的对象
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    public Array(int catacity) {
        data = (E[]) new Object[catacity];
        size = 0;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在指定位置插入元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("新增异常：索引不规范");
        }

        //如果容器已满，则触发动态扩容
        if (index == getCapacity()) {
            resize(getCapacity() * 2);
        }

        //指定位置后面的元素都往后移一位(从后往前移)
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //为指定位置赋值
        data[index] = e;
        //赋值完毕后元素的个数+1
        size++;
    }

    /**
     * 在数组顶端新添元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在数组末端新添元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 移除指定元素(只删除第一个)
     */
    public void removeElement(E e) {
        //先查找该元素的索引
        int elementIndex = findIndex(e);
        //根据索引删除元素
        if (elementIndex != -1) {
            remove(elementIndex);
        } else {
            throw new IllegalArgumentException("删除异常：要删除的元素不存在");
        }
    }

    /**
     * 移除指定元素(删除所有)
     */
    public void removeAllElement(E e) {

    }

    /**
     * 移除指定位置的元素
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除异常：索引不合法");
        }

        //指定返回值，即为删除的元素
        E result = data[index];

        //移除指定位置的元素，其后面的元素都往前移一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        //loitering object,设定成弱对象，便于GC
        data[size] = null;

        //当容器元素个数不足容量的四分之一，自动触发缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return result;
    }

    /**
     * 移除数组顶端元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除数组末端元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 查找元素索引(查找第一个)
     */
    public int findIndex(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找元素索引(查找所有)
     */
    public int[] findAllIndex(E e) {
        return new int[1];
    }

    /**
     * 查找数组中是否含指定元素
     */
    public boolean contains(E e) {
        int elementIndex = findIndex(e);
        if (elementIndex != -1) {
            return true;
        }
        return false;
    }

    /**
     * 获取指定位置的元素
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("查询失败：索引不合法");
        }
        return data[index];
    }

    /**
     * 获取数组中的第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取数组中最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新指定位置的元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("查询失败：索引不合法");
        }
        data[index] = e;
    }

    /**
     * 动态调整容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        //将原来的数据赋值到新的容器中
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array:size = %d;capacity = %d \n", size, getCapacity()));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
