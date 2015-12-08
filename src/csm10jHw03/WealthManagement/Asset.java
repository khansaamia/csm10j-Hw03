
package WealthManagement;

abstract public class Asset {
    
    private String name;
    
    public Asset(){}
    
    abstract public double getAssetValue();

    public String getName() {
        return name;
    }

    public Asset(String name){
        this.name = name;     
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
