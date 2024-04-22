package Aufgabe1;

public class SimpleAccumulator implements Accumulator {
    @Override
    public void addDataValue(double data) {
        N++;
        total+=data;

    }

    @Override
    public double mean() {
        return total/N;
    }

    int N=0;
    double total=0.0;

    @Override
    public String toString() {
        return "SimpleAccumulator{" +
                "Anzahl von Daten=" + N +
                ", total=" + total +
                '}';
    }
}
