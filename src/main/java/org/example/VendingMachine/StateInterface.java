package org.example.VendingMachine;

public interface StateInterface {

    void insertCoin(int amount);
    void dispenseProduct(int id);
    void nextState(StateInterface state);
}
