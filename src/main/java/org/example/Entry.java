package org.example;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author lukaszjelen
 * @param <K>
 * @param <V>
 */
public interface Entry<K,V> {

    K getKey();         //zwraca klucz przechowywany we wpisie KP
    V getValue();       //zwraca wartość przechowywaną we wpisie KP

}
