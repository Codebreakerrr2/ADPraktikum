package Aufgabe2;

import com.google.common.base.Preconditions;

import java.util.AbstractList;
import java.util.LinkedList;

public class  DoublyLinkedList<T> extends AbstractList<T> {


    public DoublyLinkedList() {
        start=new Node(null,end,null);
        end=new Node(null,null,start);
    }
    public DoublyLinkedList(DoublyLinkedList<T> list){
        Preconditions.checkNotNull(list);
        this.start=list.getStart();
        this.end=list.getEnd();
        start=new Node(null,end,null);
        end=new Node(null,null,start);
    }


    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    private int size;
    private Node start;
    private Node end;

    @Override
    public T get(int index) {
        Preconditions.checkArgument(index>=0,"Index für minus Zahlen existiert nicht");

        Node currentNode;
        if(size/2>index){ currentNode=start;
            for(int i=0;i<size;i++){
                if(i==index) return (T) currentNode.getItem();
                currentNode=currentNode.getNext();
            }
        }else{
            currentNode=end;
            for(int i=size-1;i>=0;i--){
                if(i==index) return (T) currentNode.getItem();
                currentNode=currentNode.getPrevious();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T t) {
        if(end==null) return false;
        Node newEnd=new Node(t,null,end);
        end.next=newEnd;
        end=newEnd;
        return true;
    }

    @Override
    public T remove(int index) {
        Preconditions.checkArgument(index>=0,"Index für minus Zahlen existiert nicht");

        Node currentNode;
        if(size/2>index){ currentNode=start;
            for(int i=0;i<size;i++){
                if(i==index){
                    Node previousNode=currentNode.previous;
                    Node nextNode= currentNode.next;
                    previousNode.next=nextNode;
                    nextNode.previous=previousNode;
                    return (T) currentNode.getItem();
                }
                currentNode=currentNode.getNext();
            }
        }else{
            currentNode=end;
            for(int i=size-1;i>=0;i--){
                if(i==index){
                    Node previousNode=currentNode.previous;
                    Node nextNode= currentNode.next;
                    previousNode.next=nextNode;
                    nextNode.previous=previousNode;
                    return (T) currentNode.getItem();
                }
                currentNode=currentNode.getPrevious();
            }
        }
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public void add(int index, T element) {
        super.add(index, element);
    }

    @Override
    public T set(int index, T element) {
        return super.set(index, element);
    }

    private class Node<T>{

        public Node(T item){
            this(item,null,null);
        }
        public Node(T item, Node next,Node previous){
            this.item=item;
            this.next=next;
            this.previous=previous;
        }
        T item;
        Node next;
        Node previous;

        public T getItem() {
            return item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    public static void main(String[] args) {

    }
}