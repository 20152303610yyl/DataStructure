package com.yyl.study;


/**
 * 手写红黑树
 * 需要实现添加、删除、遍历操作
 */
public class RBTree {

    private static final boolean RED = false;
    private static final boolean BLOCK = true;

    private Node root;//跟节点

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    //实现添加需要考虑到左旋、右旋、颜色修改的方法
    /**
     * 依据p节点进行左旋，图示
     *
     *      p               rp[r]
     *     /\                /\
     *   lp  rp[r]  --->    p  rr
     *   /   /\            /\
     * llp  rl rr         lp rl
     *  其中节点关系变化的有：p-r  --> r-p
     *  r-rl -->  p-rl
     *  p的父节点也会有变化 pp-p  --> pp-r
     * @param p 旋转的节点
     */
    public void leftRotate(Node p){
        if(p != null){
            if(p.right != null){
                Node r = p.right;
                //无论r的左节点是否为空，均应该将其设置为p的右节点
                p.right = r.left;
                if(r.left != null){
                    r.left.parent = p;
                }
                r.parent = p.parent;
                if(p.parent == null){
                    //若p没有父节点，则左旋后r为跟节点
                    this.root = r;
                } else if (p.parent.left == p) {
                    p.parent.left = r;
                }else {
                    p.parent.right = r;
                }
                //设置p的父节点为r
                p.parent = r;
                r.left = p;
            }
        }
    }

    /**
     * 依据p节点进行左旋，图示
     *
     *       p            pl[l]
     *      / \            /\
     *   pl[l] pr  --->  lp  p
     *    /\            /   /\
     *   ll lr        ll  lr pr
     *  其中节点关系变化的有：p-l  --> l-p
     *  l-lr -->  p-lr
     *  p的父节点也会有变化 pp-p  --> pp-l
     * @param p 旋转的节点
     */
    public void rightRotate(Node p){
        if(p != null){
            if(p.left != null){
                Node l = p.left;
                //无论l的右节点是否为空，均应该将其设置为p的左节点
                p.left = l.right;
                if(l.right != null){
                    l.right.parent = p;
                }
                l.parent = p.parent;
                if(p.parent == null){
                    //若p没有父节点，则右旋后l为跟节点
                    this.root = l;
                } else if (p.parent.left == p) {
                    p.parent.left = l;
                }else {
                    p.parent.right = l;
                }
                //设置p的父节点为r
                p.parent = l;
                l.right = p;
            }
        }
    }

    /**
     * 红黑节点
     */
    static class Node<K extends Comparable<K>,V>{
        private K key;
        private V value;
        //父节点
        private Node parent;
        //左子节点
        private Node left;
        //右子节点
        private Node right;
        //节点颜色
        private boolean color;

        public Node() {
        }

        public Node(K key, V value, Node parent, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }

}
