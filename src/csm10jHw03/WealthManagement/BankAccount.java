
package WealthManagement;

public class BankAccount extends Asset {
    private double balance;

    public BankAccount(String name, double balance){
        super(name);
        this.balance = balance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public double getAssetValue(){
        return getBalance();
    }
    
    @Override
    public String toString(){
        return String.format("%s, %s, Balance: $%.2f", getName(), "Bank Account", getBalance());
    }
    
}
