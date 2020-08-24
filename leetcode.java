class MyLinkedList {
    class Node{
        Node next;
        int value;
        Node(int value){
            this.value=value;
        }
    }
     Node head;
     int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head=null;
        this.size=0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index>=size||index<0)
            return -1;
        if(size==1) return head.value;
        Node temp=head;
        for(int i=0;i<index;i++)
            temp=temp.next;
        return temp.value;
        }
    
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node current=new Node(val);
        current.next=head;
        head=current;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node last=new Node(val);
        size++;
        if(head==null)
            head=last;
        else{
            Node temp=head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=last;
        }
        
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size)
            return;
        if(index<=0)
            addAtHead(val);
        else if(index==size)
            addAtTail(val);
        else{
            Node temp=head;
            for(int i=0;i<index-1;i++)
                temp=temp.next;
            Node current=new Node(val);
            current.next=temp.next;
            temp.next=current;
            size++;
        }      
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=size) return;
        size--;
        Node current=head;
        for(int i=0;i<index-1;i++)
            current=current.next;
        current.next=current.next.next;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */