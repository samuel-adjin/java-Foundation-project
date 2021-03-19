package classes;

import interfaces.IBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Bank implements IBank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    private Branch findBranch(String branchName){
        for (int i= 0; i< branches.size(); i++){
            if (branches.get(i).getName().equals(branchName)){
                return branches.get(i);
            }else{
                return null;
            }
        }
        return null;
    }


    @Override
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null){
            return false;
        }else{
            branches.add(new Branch(branchName));
            return true;
        }
    }

    @Override
    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch == null){
            return false;
        }
        branch.newCustomer(customerName,initialTransaction);

        return true;
    }

    @Override
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null){
            return false;
        }
         branch.addCustomerTransaction(customerName,transaction);
        return true;
    }

    @Override
    public boolean listCustomers(String branchName, boolean printTransaction) {
        Branch branch = new Branch(branchName);
        if (printTransaction) {
            for (int i = 0; i < branches.size(); i++) {
                for (int j = 0; j < branches.get(i).getCustomers().size(); j++) {
                    int num = j + 1;
                    System.out.println("Customer: " + branches.get(i).getCustomers().get(j).getName() + " [" + num + "]");
                    System.out.println("Transactions");
                    ListIterator<Double> a = branches.get(i).getCustomers().get(j).getTransactions().listIterator();
                    while (a.hasNext()){
                        System.out.println("Amount " + a.next() + " [" + a.nextIndex() + "]");

                    }
                }
            }
            return true;
        }

        for (int i = 0; i < branches.size(); i++) {
            for (int j = 0; j < branches.get(i).getCustomers().size(); j++) {
                int num = j + 1;
                System.out.println("Customer: " + branches.get(i).getCustomers().get(j).getName() +" [" + num +"]");
    }
        }
        return false;
    }

        }

