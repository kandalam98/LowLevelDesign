package org.example.VendingMachine;

public class VendingMachineApp {

    public static void main(String[] args){
        VendingMachine vendingMachine = new VendingMachine();
        Product product1 = new Product(1,"Coke", 5);
        InitialState state = new InitialState(vendingMachine);
        vendingMachine.addProducts(1,product1);
        vendingMachine.setNextState(state);
        vendingMachine.setAmount(1);
        vendingMachine.dispenseProduct(1);

        vendingMachine.setAmount(4);
        vendingMachine.dispenseProduct(1);
    }
}
