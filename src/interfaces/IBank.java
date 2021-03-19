package interfaces;

public interface IBank {

    public boolean addBranch(String branchName);
    public boolean addCustomer(String branchName, String customerName, double initialTransaction);
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction);
    public boolean listCustomers(String branchName, boolean printTransaction);
}
