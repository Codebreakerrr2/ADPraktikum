package Aufgabe2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    void copyConstructor(){
        List<Integer> arrayList= Arrays.asList(1,2,3,4,5,6,7,8,81,23,412,5,6123,12);
        DoublyLinkedList<Integer> doubleLinked= new DoublyLinkedList<>(arrayList);

        Assertions.assertArrayEquals(arrayList.toArray(),doubleLinked.toArray());
    }

    @Test
    void add() {

    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
    }

    @Test
    void contains() {
    }
}