package com.liuhu.datastruct.linkedList;
/**
 *  @Description 单链表
 *  @author liuhu
 *  @Date 2021/3/8 15:20
 */
public class LinkedList {

    /**根节点*/
    private Node root;

    /**长度*/
    private long size;

    public LinkedList() {
        this.root = null;
        this.size = 0;
    }

    /**
     *  @Description 单链表  主要有一个元素和一个指针  指针指向下一个节点
     *  @author liuhu
     *  @Date 2021/3/8 15:21
     */
    class Node<T>{

        private T data;

        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    /**
     * @Description 新增
     * @author liuhu
     * @param data
     * @date 2021/3/8 15:28
     * @return void
     */
    public void insert(Object data){
        Node newNode = new Node(data);
        if(null == root){
            root = newNode;
        }else {
            Node currentNode = root;
            // 直到找到链表的尾部即最后一个节点的下一个节点指向null   然后加入新插入的结点
            while (currentNode.next != null){
                // 如果不符合  节点后移继续查找
                currentNode = currentNode.next;
            }
            // 指向新节点
            currentNode.next=newNode;
        }
        size++;
    }

    /**
     * @Description 查找指定位置的元素
     * @author liuhu
     * @param index
     * @date 2021/3/8 15:31
     * @return com.liuhu.datastruct.linkedList.LinkedList.Node
     */
    public Node getNode(int index){
        Node currentNode = root;
        for (int i = 0; i < index; i++) {
            currentNode=currentNode.next;
        }
        return currentNode;
    }

    /**
     * @Description 遍历打印
     * @author liuhu
     * @date 2021/3/8 15:31
     * @return void
     */
    public void print(Node head){
        Node currentNode = head;
        // 注意 此时不能用currentNode.next != null为判断条件  因为最后一个节点的下一个节点为null  空指针
        while (currentNode !=null){
            System.out.println(currentNode.getData());
            currentNode=currentNode.next;
        }
        System.out.println("链表长度为："+size);
    }

    /**
     * @Description 指定位置插入元素 首先找到 指定位置的当前节点 和 上一个节点  上一个节点指向新节点  新节点指向当前节点
     * @author liuhu
     * @param index
     * @param data
     * @date 2021/3/8 15:38
     * @return void
     */
    private void insert(int index,Object data){
        Node newNode = new Node(data);
        // 如果在头部插入
        if(index == 0){
            newNode.next=root;
        }else {
            // 当前节点
            Node node = getNode(index);
            //上一个节点
            Node preNode = getNode(index-1);
            preNode.next = newNode;
            newNode.next=node;
        }
        size++;
    }

    /**
     * @Description 删除指定节点的数据  思路  把要删除的节点的上一个节点指向要删除节点的下一个节
     * 点（ 上一个节点-》要删除节点-》下一个节点） 变成 （上一个节点-》下一个节点）
     * @author liuhu
     * @param index
     * @date 2021/3/8 15:45
     * @return void
     */
    public void delete(int index){
        if(index>size){
            return;
        }
        // 删除首节点  节点直接后移
        if(index == 0){
            root = root.next;
        }else {
            Node preNode = getNode(index - 1);
            Node nextNode = getNode(index+1);
            preNode.next=nextNode;
        }
        size--;
    }

    /**
     * @Description 思路 先找出对吼一个节点  递归把最后一个节点指向前一个节点
     * @author liuhu
     * @date 2021/3/8 15:55
     * @return void
     */
    public Node reverse(Node head) {
        // 递归退出标志  找到最后一个节点
      if(head == null || head.next == null){
          return head;
      }
      //最后一个节点
      Node lastNode = head.next;
      // lastHead是最后一个节点 head 就是前一个节点
      Node newHead = reverse(head.next);
      // 反转 后一个节点指向  前一个节点
      lastNode.next=head;
      //把之前的指向置为空
       head.next=null;
      return newHead;
    }



    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(6);
        linkedList.insert(3);
        linkedList.insert(8);
        linkedList.insert(56);
//        linkedList.insert(2,66);
//        linkedList.delete(3);
        linkedList.print(linkedList.root);
        Node node = linkedList.reverse(linkedList.root);
        linkedList.print(node);
//        System.out.println(linkedList.getNode(2).data);
    }
}
