package Aufgabe2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        /*
0 1
2 1
1 3
6 9
4 7
5 8
1 5
1 8
9 1
8 2
8 3
8 4
         */
        UFBase ds= new QuickFind(10);
        ds.union(0,1);
        StdOut.printf(Arrays.toString(ds.id));
        ds.union(2,1);
    }
}

