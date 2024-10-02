package org.example.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    int amount =0;
    Map<Integer, Product> productQuantity = new HashMap<>();

    StateInterface nextState;
    InitialState initialState;
    public VendingMachine() {
        this.initialState = new InitialState(this);
        this.nextState = initialState;
    }

    public StateInterface getNextState() {
        return nextState;
    }

    public void setNextState(StateInterface nextState) {
        this.nextState = nextState;
    }

    public int getAmount() {
        return amount;
    }
    public void addAmount(int amount){
        this.amount += amount;
    }

    public void setAmount(int amount) {
        this.nextState.insertCoin(amount);
    }
    public void dispenseProduct(int id){
        this.nextState.dispenseProduct(id);
    }

    public Map<Integer, Product> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Map<Integer, Product> productQuantity) {
        this.productQuantity = productQuantity;
    }

    void addProducts(int productId, Product productName){
        productQuantity.put(productId, productName);
    }
}
