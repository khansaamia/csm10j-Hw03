
package WealthManagement;

abstract public class Security extends Asset {
    private int quantity;
    private double price;
    
    public Security(String name, int quantity, double price){
        super(name);
        this.quantity = quantity;
        this.price = price;
    }
    
    public Security(){
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public double getAssetValue(){
        return getQuantity() * getPrice();
    } 
    
    @Override
    public String toString(){
        return String.format("%s, %s, Quantity: %d, Price: $%.2f, Value: $%.2f",
                getName(), 
                this.getClass().getSimpleName(),  
                getQuantity(), 
                getPrice(),
                getAssetValue());
    }

}
