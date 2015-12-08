
package javagui;

import WealthManagement.Asset;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class AssetForm extends Observable {
    
    public List<Asset> assets = new ArrayList<Asset>();
    public List<Observer> obs = new ArrayList<Observer>();
    
    public AssetForm() {    
        super();
    }
    
    
    public AssetForm(Vector<Asset> asset)
    {
        this.assets=asset;
    }
    
    public Asset getAssetList()
    {
        return this.getAssetList();
    }

    
     public void addObserver(Observer anObs) {
        obs.add(anObs);
        
    }
     
    public void notifyObservers(Asset ass) {
        for (Observer anObs: obs) {
            anObs.update(this, ass);
        }
    }
    
}
