package org.example;

import org.example.BookMyShow.BookMyShow;
import org.example.ConcurrencyLocking.OptimisticLocking.OptimisticImpl;
import org.example.ConcurrencyLocking.PessimisticLocking.PessimicticLocking;
import org.example.ConcurrencyLocking.PessimisticLocking.PessimisticWithoutLock;
import org.example.HashMapImplementation.MyHashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello HashMap Implementation !");

//        MyHashMap<Integer,String> myHashMap = new MyHashMap<>(4);
//        myHashMap.put(1,"A");
//        myHashMap.put(2,"B");
//        System.out.println(myHashMap.get(1));
//        System.out.println(myHashMap.get(3));

//        try {
//            OptimisticImpl optimistic = new OptimisticImpl();
//        }catch (Exception ex){
//            System.out.println("Exception during optimistic " + ex.getMessage());
//        }
//        PessimicticLocking pessimicticLocking = new PessimicticLocking();
//        PessimisticWithoutLock pessimisticWithoutLock = new PessimisticWithoutLock();

        BookMyShow  bookMyShow = new BookMyShow();

    }
}