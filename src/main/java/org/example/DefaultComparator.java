package org.example;

import java.util.Comparator;

/**
 *
 * @author lukaszjelen
 */
public class DefaultComparator<E> implements Comparator<E> {
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}