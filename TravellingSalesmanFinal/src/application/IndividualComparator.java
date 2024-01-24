package application;

import java.util.Comparator;

public class IndividualComparator implements Comparator<Individual> {
    @Override
    public int compare(Individual A, Individual B) {
        return Integer.compare(A.getCost(), B.getCost());
    }
}