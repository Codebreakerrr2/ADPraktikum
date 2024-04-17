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
    int[] gefundeneBereich=null;




}

/**
 * @author Usman Amini
 * die Methode untersucht ein Array von einem gegebenen Index bis zu einem anderen gegebenen Index, ob das Array in dem Bereich aufsteigend sortiert ist.
 * @param array
 * @param von
 * @param bis
 * @return true/false
 * */
private static boolean istAufsteigendSortiert(int[] array, int von, int bis){
    Preconditions.checkNotNull(array);
    Preconditions.checkArgument(von<bis,"Falsche Indizes");
    for(int i=von;i<bis;i++){
        if(array[i]<array[i+1]) return false;

    }
    return true;
}
/**
 * @author Usman Amini
 * die Methode sucht in einem gegebenem Bereich eines Arrays, ob es sich da ein lokales Minimum befindet.
 * @param array
 * @param von
 * @param bis
 * @return true/false
 * */
private static boolean localMaxHelp(int[] array,int von, int bis){
    int mitte=1+(bis-von)

}

}
