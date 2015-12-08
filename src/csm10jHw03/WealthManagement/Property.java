
package WealthManagement;

abstract public class Property extends Asset{
    private double propertyValue;
    private double debtAmount;

    public Property(String name, double propertyValue, double debtAmount){
        super(name);
        this.propertyValue = propertyValue;
        this.debtAmount = debtAmount;
    }
    
    public double getDebtAmount() {
        return debtAmount;
    }
    
    public double getPropertyValue() {
        return propertyValue;
    }
    
    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }
    
    public void setDebtAmount(double debtAmount) {
        this.debtAmount = debtAmount;
    }
    
    @Override
    public double getAssetValue(){
        return getPropertyValue();
    }
    
    @Override
    public String toString(){
        return String.format("%s, %s, Value: $%.2f, Debt: $%.2f", 
                getName(), 
                this.getClass().getSimpleName(), 
                getAssetValue(),
                getDebtAmount());
    }


}
