package org.example.VendingMachine;

import org.example.LoggerImpl.Logger;

public class DispenedState implements StateInterface{
    VendingMachine vendingMachine;
    Logger logger = new Logger();


    public DispenedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCoin(int amount) {
        logger.info("Cannot add in dispensed state");
    }

    @Override
    public void dispenseProduct(int id) {
        if(vendingMachine.getProductQuantity().containsKey(id)){
            Product product  = vendingMachine.getProductQuantity().get(id);
            if(product.getPrice() <= vendingMachine.getAmount()){
                System.out.println("Product dispensed");
                vendingMachine.addAmount(vendingMachine.getAmount()-product.getPrice());
                vendingMachine.getProductQuantity().remove(product);
                vendingMachine.setNextState(new InitialState(vendingMachine));
            }else {
                vendingMachine.setNextState(new InitialState(vendingMachine));
                System.out.println("Please add money ");
            }
        }else {
            logger.info("Product not available in the Machine");
        }
    }

    @Override
    public void nextState(StateInterface state) {

    }
}
