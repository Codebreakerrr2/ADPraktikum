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
   return localMax(array,0,array.length-1,radius);

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
        if(array[i]>=array[i+1]) return false;

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
            if(array[i]<=array[i+1]) return false;

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
    int mitte = lo+ (laenge)/ 2;
    Preconditions.checkArgument(array.length >= laenge, "die Array hat eine kürzere Länge als der gegebene Bereich");
    if(array.length==1) return true;
    return   istAufsteigendSortiert(array, lo, mitte) && istAbsteigendSortiert(array, mitte, hi);
}
    /**
     * @author Usman Amini
     * die Methode sucht in einem Array rekursiv nach dem lokalen Maximum, findet die Methode den TeilArray, dann
     * liefert sie den Array, sonst null.
     * @param radius
     * @param array
     * @param lo
     * @param hi
     * @return teilArray/null
     * */

    private static int[] localMax(int[] array, int lo, int hi,int radius) {

        int laenge = 1 + (hi - lo);
        int mitte= lo+ (laenge)/2;
        int intervallLo= mitte-radius;
        int intevallHi= mitte+radius;
        int intervallLaenge=1+(intevallHi-intervallLo);


        if(intervallLaenge<=laenge){
            if(existsLocalMax(array,intervallLo,intevallHi)){
                int[] gefundenerBereich= new int[intervallLaenge];
                System.arraycopy(array,intervallLo,gefundenerBereich,0,intervallLaenge);
                return gefundenerBereich;
            }

            if(array[mitte+1]>=array[mitte-1]){

               return localMax(array,lo,mitte-1,radius);
            }
            else{
              return localMax(array,mitte+1,hi,radius);
            }


        }

return null;


    }

    public static void main(String[] args) {
        int [] array={1, 61, 16, 75, 89, 133, 89, 59, 28, 3, 3, 97, 61, 85, 47, 38, 78, 7, 6, 15
};
        int[] teilArray= TeilA.localMax(array,3);
        if(teilArray==null) System.out.println("fk");
        else printArray(teilArray);
    }

    public static void printArray(int[] array){
        for(int zahl: array)
            System.out.printf("%d,",zahl);
    }

}