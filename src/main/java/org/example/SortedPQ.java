package org.example;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Comparator;

/**
 *
 * @author lukaszjelen
 */
public class SortedPQ<K,V> extends AbstractPriorityQueue<K,V> {

    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
    // dp przechowywania informacji

    //konsturktor
    public SortedPQ( ) { super(); }

    public SortedPQ(Comparator<K> comp) { super(comp); }

    @Override
    public int size() { return list.size(); }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) return null;
        return (Entry<K, V>) list.remove(list.first());
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key, value);
        Position<Entry<K,V>> walk = list.last();
        //cofamy się w liście
        while (walk != null && compare(newest, walk.getElement())<0)
            walk = list.before(walk);
        if (walk == null)
            list.addFirst(newest);
        else
            list.addAfter(walk, newest);
        return (Entry<K, V>) newest;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) return null;
        return (Entry<K, V>) list.first().getElement();
    }
}
