package Aufgabe1;

import java.util.Random;

public class Probability {
    /**
     * @autor Usman Amini
     * die Methode liefert a mit der gegebenen Wahrscheinlichkeit, ansosnten b.  p(item1)+p(item2)=1
     * @param item1
     * @param item2
     * @param probabilityOfItem1
     * */
    public static Object applyProbability(Object item1, Object item2, double probabilityOfItem1){
        Random rand= new Random();

        if(probabilityOfItem1>rand.nextDouble()) return item1;
        return item2;
    }
}