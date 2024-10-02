package org.example.VendingMachine;

import org.example.LoggerImpl.Logger;

import java.util.Map;

public class InitialState implements  StateInterface{
    Logger logger = new Logger();

    VendingMachine vendingMachine;

    public InitialState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.addAmount(amount);
        logger.info("Amount added successfully");
        vendingMachine.setNextState(new DispenedState(vendingMachine));
    }

    @Override
    public void dispenseProduct(int id) {
        logger.info("Please add amount to dispense product");
    }

    @Override
    public void nextState(StateInterface state) {
        vendingMachine.setNextState(state);
    }
}
