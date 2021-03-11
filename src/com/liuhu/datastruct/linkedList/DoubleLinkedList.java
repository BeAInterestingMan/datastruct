package com.liuhu.datastruct.linkedList;
/**
 *  @Description 双向链表
 *  @author liuhu
 *  @Date 2021/3/11 16:20
 */
public class DoubleLinkedList {

    private DoubleNode  root;

    /**
     *  @Description  双链表结构右一个数据项 两个指针 一个指针pre指向上一个节点  一个指针next指向下一个节点
     *  @author liuhu
     *  @Date 2021/3/11 16:24
     */
    class  DoubleNode<T>{

        private T data;

        private DoubleNode  pre;

        private DoubleNode next;

        public DoubleNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DoubleNode getPre() {
            return pre;
        }

        public void setPre(DoubleNode pre) {
            this.pre = pre;
        }

        public DoubleNode getNext() {
            return next;
        }

        public void setNext(DoubleNode next) {
            this.next = next;
        }
    }

    /**
     * @Description 尾插法
     * @author liuhu
     * @param data
     * @date 2021/3/11 16:26
     * @return void
     */
    public void insertLast(Object data){
        DoubleNode newNode = new DoubleNode(data);
        if(root == null){
            root = newNode;
        }else {
            DoubleNode current=root;
            // 如果当前节点后有一个节点没有值则插入
            if(current.next!=null){
                // 依次往后查找
               current = current.next;
            }
            // 赋值
            current.next=newNode;
            newNode.pre=current;
        }
    }

    /**
     * @Description 头插法
     * @author liuhu
     * @param data
     * @date 2021/3/11 16:37
     * @return void
     */
    public void insertHead(Object data){
        DoubleNode newNode = new DoubleNode(data);
        if(root == null){
            root = newNode;
        }else {
            // root节点得前节点变为了新1节点
             root.pre=newNode;
            // 下一个节点为root;
            newNode.next=root;
            // root节点就变成了新节点
            root = newNode;
        }
    }

    /**
     * @Description 查找指定元素得节点
     * @author liuhu
     * @param index
     * @date 2021/3/11 16:45
     * @return com.liuhu.datastruct.linkedList.DoubleLinkedList.DoubleNode
     */
    public DoubleNode getNode(int index){
        if(index == 0){
            return root;
        }
        DoubleNode node=root;
        for (int i = 1; i <index ; i++) {
            node=node.next;
        }
        return node;
    }


    /**
     * @Description 打印
     * @author liuhu
     * @param
     * @date 2021/3/11 16:43
     * @return void
     */
    public void print(){
        if(root == null){
            return;
        }
        DoubleNode current = root;
        while (current!=null){
            System.out.println("前一个节点："+(null == current.pre?"无":current.pre.data)+" 当前值:"+current.data
                    +"后一个节点："+(null == current.next?"无":current.next.data));
            current=current.next;
        }
    }
}
