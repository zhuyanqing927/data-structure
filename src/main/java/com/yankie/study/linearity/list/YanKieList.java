package com.yankie.study.linearity.list;

public interface YanKieList<E> {
    /**
     * 获取数组元素个数
     */
    int size();

    /**
     * 判断集合是否为空
     */
    boolean isEmpty();

    /**
     * 判断集合中是否包含指定元素
     *
     * @param e 被查找的元素对象
     * @return 包含返回true，否则返回false
     */
    boolean contains(E e);

    /**
     * 新增元素
     *
     * @param e 被新增的元素对象
     */
    boolean add(E e);

    /**
     * 新增元素到指定位置
     *
     * @param index 指定位置
     * @param e     被新增的元素对象
     */
    void add(int index, E e);

    /**
     * 删除指定元素
     *
     * @param e 被删除的元素对象
     * @return 返回删除结果，删除成功则为true,否则为false
     */
    boolean remove(E e);

    /**
     * 删除指定位置的元素
     *
     * @param index 指定位置
     * @return 返回被删除元素
     */
    E remove(int index);

    /**
     * 全部删除指定元素
     *
     * @param e 指定元素
     * @return 返回删除结果，删除成功则为true,否则为false
     */
    boolean removeAll(E e);

    /**
     * 获取指定位置的元素
     *
     * @param index 指定位置
     * @return
     */
    E get(int index);

    /**
     * 更新指定位置的元素对象
     *
     * @param index 指定位置
     * @param e     替换后的对象
     * @return 更新后的元素
     */
    E set(int index, E e);

    /**
     * 从前往后获取元素的位置
     *
     * @param e 指定元素
     * @return 元素所在位置（从0开始）
     */
    int indexOf(E e);

    /**
     * 从后往前获取元素的位置
     *
     * @param e 指定元素
     * @return 元素所在位置（从0开始）
     */
    int lastIndexOf(E e);
}
