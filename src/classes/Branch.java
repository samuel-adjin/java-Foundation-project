package classes;

import interfaces.IBranch;

import java.util.ArrayList;

public class Branch implements IBranch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    private Customer findCustomer(String name){
//         Customer customer = new Customer(name,0.0);
        for (int i = 0; i < customers.size(); i++) {
          if (customers.get(i).getName().equals(name)){
              return customers.get(i);

          }
        }
        return null;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    @Override
    public boolean newCustomer(String customerName, double initialTransaction) {
        Customer customer = findCustomer(customerName);
        if (customer == null){
            this.customers.add( new Customer(customerName,initialTransaction));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomerTransaction(String customerName, double transaction) {
        Customer customer = findCustomer(customerName);

        if (findCustomer(customerName) != null ){
            //customer = new Customer(customerName,transaction)
//            System.out.println(customer.getTransactions());
            customer.addTransaction(transaction);
//            System.out.println(customer.getTransactions());
            return true;
        }
//


        return false;
    }


}

