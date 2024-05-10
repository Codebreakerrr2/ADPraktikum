package Aufgabe2;

import com.google.common.base.Preconditions;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Objects;

public class  DoublyLinkedList<T> extends AbstractList<T> {

    public DoublyLinkedList() {
        start=new Node(null,end,null);
        end=new Node(null,null,start);
    }
    public DoublyLinkedList(Collection<? extends T> list){
        Preconditions.checkNotNull(list);
        addAll(list);
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
                currentNode=currentNode.next;
            }
        }else{
            currentNode=end;
            for(int i=size-1;i>=0;i--){
                if(i==index) return (T) currentNode.getItem();
                currentNode=currentNode.previous;
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
        size++;
        return true;
    }
    @Override
    public void add(int index, T element) {
        Preconditions.checkArgument(index>=0,"Index für minus Zahlen existiert nicht");
        Preconditions.checkArgument(index<size,"die liste ist zu klein für den Index");

        Node currentNode;
        if(size/2>index){ currentNode=start;
            for(int i=0;i<size;i++){
                if(i==index){
                    Node curPreviousNode=currentNode.previous;
                    Node newNode=new Node<T>(element,currentNode,curPreviousNode);
                    curPreviousNode.next=newNode;
                    currentNode.previous=newNode;
                    size++;
                    return;
                }
                currentNode=currentNode.next;
            }
        }else{
            currentNode=end;
            for(int i=size-1;i>=0;i--){
                if(i==index){
                    Node curPreviousNode=currentNode.previous;
                    Node newNode=new Node<T>(element,currentNode,curPreviousNode);
                    curPreviousNode.next=newNode;
                    currentNode.previous=newNode;
                    size++;
                    return;
                }
                currentNode=currentNode.previous;
            }
        }
    }

    @Override
    public T remove(int index) {
        Preconditions.checkArgument(index>=0,"Index für minus Zahlen existiert nicht");
        Preconditions.checkArgument(index<size,"die liste ist zu klein für den Index");

        Node currentNode;
        if(size/2>index){
            currentNode=start;
            for(int i=0;i<size;i++){
                if(i==index){
                    Node previousNode=currentNode.previous;
                    Node nextNode= currentNode.next;
                    previousNode.next=nextNode;
                    nextNode.previous=previousNode;
                    size--;
                    return (T) currentNode.getItem();
                }
                currentNode=currentNode.next;
            }
        }else{
            currentNode=end;
            for(int i=size-1;i>=0;i--){
                if(i==index){
                    Node previousNode=currentNode.previous;
                    Node nextNode= currentNode.next;
                    previousNode.next=nextNode;
                    nextNode.previous=previousNode;
                    size--;
                    return (T) currentNode.getItem();
                }
                currentNode=currentNode.previous;
            }
        }
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)>=0;
    }

    private class Node<T>{

        private Node(T item){
            this(item,null,null);
        }
        public Node(T item, Node next,Node previous){
            this.item=item;
            this.next=next;
            this.previous=previous;
        }
       private T item;
       private Node next;
       private Node previous;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(item, node.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }
    }

    public static void main(String[] args) {

    }
}
