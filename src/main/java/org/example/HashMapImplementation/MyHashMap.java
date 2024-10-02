package org.example.HashMapImplementation;

import java.util.Map;

public class MyHashMap<K,V> {

    public static int initialSize = 1 << 4;
    public static final int maxSize = 1 << 30;

    public Entry[] hashTable;
    public MyHashMap() {
        hashTable = new Entry[initialSize];
    }
    public MyHashMap(int size) {
        int tableSize = findSize(size);
        hashTable = new Entry[tableSize];
    }

    private int findSize(int size) {
        //Little tricky
        //Refer Concept and Coding video for better understanding
        int n = size - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return (n < 0) ? 1 : (n >= maxSize ) ? maxSize : n+1;
    }

    public void put(K key , V value){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node =  hashTable[hashCode];
        if( hashTable[hashCode] == null ){
            Entry newNode = new Entry(key,value);
            hashTable[hashCode] = newNode;
        } else {
            Entry previousNode = node;
            while( node != null  ){
                if(node.key == key){
                    node.value = value;
                    return ;
                }
                previousNode = node ;
                node = node.next ;
            }
            Entry newNode = new Entry(key,value);
            previousNode.next = newNode;
        }
    }

    public V get(K key ){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node =  hashTable[hashCode];
        if(node != null ){
            while(node != null ){
                if(node.key == key){
                    return (V) node.value;
                }
                node = node.next;
            }
        }
        return null;
    }

    class Entry<K,V> {
        public K key;
        public  V value;
        public Entry next;
        Entry(K k, V v){
            this.key = k;
            this.value = v;
        }
    }

}
