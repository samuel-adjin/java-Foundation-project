package interfaces;

import java.util.ArrayList;

public interface ICustomer {
    public void addTransaction(double transaction);
    public String getName();
    public ArrayList<Double> getTransactions();
}
