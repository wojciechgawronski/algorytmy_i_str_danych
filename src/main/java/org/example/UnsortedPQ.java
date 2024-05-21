package org.example;

import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lukaszjelen
 */
public class UnsortedPQ<K,V> extends AbstractPriorityQueue<K,V> {

    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
    // dp przechowywania informacji

    //konsturktor
    public UnsortedPQ( ) { super(); }

    public UnsortedPQ(Comparator<K> comp) { super(comp); }

    //zwracanie pozycji dla elementu o najmniejszym kluczu
    private Position<Entry<K,V>> findMin() {

        Position<Entry<K,V>> small = list.first( );
        for (Position<Entry<K,V>> walk : list.positions( ))
            if (compare(walk.getElement( ), small.getElement( )) < 0)
                small = walk;
        return small;
    }



    @Override
    public int size() { return list.size(); }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) return null;
        return (Entry<K, V>) list.remove(findMin());
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);    // auxiliary key-checking method (could throw exception)
        Entry<K,V> newest = new PQEntry<>(key, value);
        list.addLast(newest);
        return (Entry<K, V>) newest;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) return null;
        return (Entry<K, V>) findMin().getElement();
    }



}