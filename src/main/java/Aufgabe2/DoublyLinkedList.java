package Aufgabe2;

import com.google.common.base.Preconditions;



import java.util.*;

public class DoublyLinkedList<T> extends AbstractList<T> {

    private int size=0;
    private Node start;
    private Node end;
    public DoublyLinkedList() {

        start = new Node(null);
        end = new Node(null);
        start.next = end;
        end.previous = start;
    }
    public DoublyLinkedList(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }
    @Override
    public T get(int index) {
        Node currentNode;
        if(size/2>index){
            currentNode=start;
            for(int i=0;i<index;i++) {
                currentNode = currentNode.next;
            }
            return currentNode.next.item;

        }
        else{
            currentNode=end;
            for(int i=size-1;i>index;i--){
                currentNode=currentNode.previous;}
            return currentNode.previous.item;


        }
    }

    @Override
    public int size() {
        return size;
    }



    @Override
    public void add(int index, T item) {

        Node currentNode;
        if (size / 2 >= index) {
            currentNode = start;
            for (int i = -1; i < index; i++) {
                currentNode = currentNode.next;
            }

            Node curPrevious = currentNode.previous;
            Node newNode = new Node(item, curPrevious, currentNode);
            currentNode.previous = newNode;
            curPrevious.next = newNode;
            size++;
        } else {
            currentNode = end;
            for (int i = size ; i > index; i--) {
                currentNode = currentNode.previous;
            }

            Node curPrevious = currentNode.previous;
            Node newNode = new Node(item, curPrevious, currentNode);
            currentNode.previous = newNode;
            curPrevious.next = newNode;
            size++;
        }
    }


    @Override
    public T remove(int index) {
        Preconditions.checkArgument(index<size && index >=0,"IndexOutOfBound" );
        Node currentNode;

        if (size / 2 >= index) {
            currentNode = start;
            for (int i = -1; i < index; i++) {
                currentNode = currentNode.next;
            }

            Node curPrevious = currentNode.previous;
            Node curNext = currentNode.next;
            curPrevious.next = curNext;
            curNext.previous = curPrevious;
            size--;
            return currentNode.item;


        }
        else{
            currentNode=end;
            for (int i =size; i > index; i--) {
                currentNode = currentNode.previous;
            }

            Node curPrevious=currentNode.previous;
            Node curNext=currentNode.next;
            curPrevious.next=curNext;
            curNext.previous=curPrevious;
            size--;
            return currentNode.item;
        }
    }

    @Override
    public T set(int index, T item) {
        Preconditions.checkArgument(index<size && index >=0,"IndexOutOfBound" );
        Node currentNode;

        if (size / 2 >= index) {
            currentNode = start;
            for (int i = -1; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.item=item;
            return currentNode.item;
        }
        else{
            currentNode=end;
            for (int i = size; i > index; i--) {
                currentNode = currentNode.previous;
            }
            currentNode.item=item;
            return currentNode.item;
        }

    }

    @Override
    public void clear() {
        super.clear();
    }

    private class Node{

        public Node(T item){
            this.item=item;
        }
        public Node(T item,Node previous,Node next){
            this.item=item;
            this.next=next;
            this.previous=previous;
        }
        private Node next;
        private Node previous;
        private T item;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return item.equals(node.item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item);
        }

        @Override
        public String toString() {
            return String.valueOf(item);
        }
    }


    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Set<Integer> set= new HashSet<>();
        Collections.addAll(list,1,2,3,4,5,1,2,3,56);
        Collections.addAll(set,1,2,3,4,5,6,7,8);



        DoublyLinkedList<Integer> dList= new DoublyLinkedList<>(list);
        DoublyLinkedList<Integer> dList2= new DoublyLinkedList<>(set);
        System.err.println(dList2);
        System.err.println(dList);


        dList.add(1,321);
        System.err.println(dList);
        dList.add(dList.size/2,321);
        System.err.println(dList);
        dList.add(dList.size,321);
        System.err.println(dList);
        dList.set(0,4312);
        System.err.println(dList);
        dList.remove(0);
        dList.remove(dList.size/2);
        dList.remove(dList.size-1);
        System.err.println(dList);
        dList.clear();
        System.err.println(dList);
        dList.addAll(list);
        Iterator<Integer> iterator= dList.iterator();
        while (iterator.hasNext()){
            System.err.println(iterator.next());
        }
        dList.stream().forEach(e->System.err.println(e));
        Object[] array= dList.toArray();
        System.err.println(dList);




    }

}
