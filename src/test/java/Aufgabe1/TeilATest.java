package Aufgabe1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TeilATest {

    @Test
    void localMax() {
        int [] array={1,2,3,4,5,6,7,7,12,3,2,12,45,5};
        int[] teilArray= TeilA.localMax(array,2);
        System.out.println(teilArray);
    }
}