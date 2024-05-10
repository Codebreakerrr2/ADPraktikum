package Aufgabe1;

import edu.princeton.cs.algs4.StdRandom;

public class NumberGenerator {

   public static void main(String[] args) {

       int anzahlZahlen= Integer.parseInt(args[0]);
       double min= Double.parseDouble(args[1]);
       double max= Double.parseDouble(args[2]);
       for(int i=0; i<anzahlZahlen;i++){
           double doubleNumber;
           while((doubleNumber= StdRandom.uniformDouble(min,max+1))>max);
           int intNumber= StdRandom.uniformInt((int)min,(int)max+1);
           if(5>StdRandom.uniformInt(0,11)) {
               System.out.println(doubleNumber+" ");
           }
           else{
               System.out.print(intNumber+" ");
           }
       }
   }





}
