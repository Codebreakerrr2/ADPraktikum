package Aufgabe1;

import com.google.common.base.Preconditions;


public class TeilA {

    /**
     * @author Usman Amini
     * die Methode sucht das lokale Maxium in einem gegebenem Radius in einem Array.
     * @param array von Typ Int
     * @param radius von Typ Int
     * @return array
     * */
public  static int [] localMax(int[] array,int radius){



}

/**
 * @author Usman Amini
 * die Methode untersucht ein Array von einem gegebenen Index bis zu einem anderen gegebenen Index, ob das Array in dem Bereich aufsteigend sortiert ist.
 * @param array
 * @param lo
 * @param hi
 * @return true/false
 * */
private static boolean istAufsteigendSortiert(int[] array, int lo, int hi){
    Preconditions.checkNotNull(array);
    Preconditions.checkArgument(hi > lo,"Falsche Indizes");
    for(int i=lo;i<hi;i++){
        if(array[i]>array[i+1]) return false;

    }
    return true;
}
    /**
     * @author Usman Amini
     * die Methode untersucht ein Array von einem gegebenen Index bis zu einem anderen gegebenen Index, ob das Array in dem Bereich absteigend sortiert ist.
     * @param array
     * @param lo
     * @param hi
     * @return true/false
     * */
    private static boolean istAbsteigendSortiert(int[] array, int lo, int hi){
        Preconditions.checkNotNull(array);
        Preconditions.checkArgument(hi > lo,"Falsche Indizes");
        for(int i=lo;i<hi;i++){
            if(array[i]<array[i+1]) return false;

        }
        return true;
    }
/**
 * @author Usman Amini
 * die Methode sucht in einem gegebenem Bereich eines Arrays, ob es sich da ein lokales Minimum befindet.
 * Vorbeingung: ist die Länge der Array 1 dann haben wir ein Element, was das Maximum ist.
 * @param array
 * @param lo
 * @param hi
 * @return true/false
 * */
private static boolean existsLocalMax(int[] array, int lo, int hi) {
    Preconditions.checkArgument(lo < hi, "Falsche Indizes");
    int laenge = 1 + (hi - lo);
    int mitte = laenge / 2;
    Preconditions.checkArgument(array.length >= laenge, "die Array hat eine kürzere Länge als der gegebene Bereich");
    if(array.length==1) return true;
    return   istAufsteigendSortiert(array, lo, mitte) && istAbsteigendSortiert(array, mitte, hi);
}
    private static int[] helpLocalMax(int[] array, int lo, int hi,int radius) {
        int laenge = 1 + (hi - lo);
        int mitte= laenge/2;
        int intervallLo= mitte-radius;
        int intevallHi= mitte+radius;
        int intervallLaenge=1+(intevallHi-intervallLo);


    }

}