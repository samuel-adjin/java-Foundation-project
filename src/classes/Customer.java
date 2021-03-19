package classes;

import interfaces.ICustomer;

import java.util.ArrayList;

public class Customer implements ICustomer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialAmount);
    }


    @Override
    public void addTransaction(double transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }
}
