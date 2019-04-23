package com.yankie.study.tree.binarysearchtree;

/**
 * 自定义二分搜索树
 * 二分搜索树存储的元素必须具有可比性，所以元素得有比较方法
 *
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E data;
        public Node left, right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * 获取元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树中添加元素
     */
    public void add(E e) {
        if (null == root) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if (node.data.equals(e)) {
            return;
        } else if (e.compareTo(node.data) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.data) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.data) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    /**
     * 判断是否存在指定元素
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        }

        if (e.compareTo(node.data) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序遍历的递归实现
     */
    private void preOrder(Node node) {
        if (null == node) {
            return;
        }

        System.out.println(node.data);
        //遍历左子树
        preOrder(node.left);
        //遍历右子树
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * 特点：结果是排序的
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历的递归实现
     */
    private void inOrder(Node node) {
        if (null == node) {
            return;
        }

        //遍历左子树
        inOrder(node.left);
        System.out.println(node.data);
        //遍历右子树
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        preOrder(root);
    }

    /**
     * 后序遍历的递归实现
     */
    private void postOrder(Node node) {
        if (null == node) {
            return;
        }

        //遍历左子树
        postOrder(node.left);
        //遍历右子树
        postOrder(node.right);
        System.out.println(node.data);
    }

    /**
     * 获取最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("二叉树为空");
        }

        return minimum(root).data;
    }

    /**
     * 获取最小元素的递归实现逻辑
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return minimum(node.left);
        }
    }

    /**
     * 获取最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("二叉树为空");
        }

        return maximum(root).data;
    }

    /**
     * 获取最大元素的递归实现逻辑
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return maximum(node.right);
        }
    }

    /**
     * 删除二叉搜索树中的最小元素
     */
    public E removeMin() {
        E returnResult = minimum();
        root = removeMin(root);
        return returnResult;
    }

    /**
     * 删除二叉搜索树中的最小元素递归实现逻辑
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二叉搜索树中的最大元素
     */
    public E removeMax() {
        E returnResult = maximum();
        root = removeMax(root);
        return returnResult;
    }

    /**
     * 删除二叉搜索树中的最大元素递归实现逻辑
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }


    @Override
    public String toString() {
        return "";
    }
}
