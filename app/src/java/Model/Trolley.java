package Model;

import java.util.ArrayList;

public class Trolley {

    private ArrayList<OrderItems> bundleOfBoots;
    private double totalPrice;
    private double deliveryCost;
    /**
     * @return the bundleOfBoots
     */
    
    public Trolley(){
        this.bundleOfBoots = new  ArrayList<OrderItems>();
    }
    
    
    public ArrayList<OrderItems> getBundleOfBoots() {
        return bundleOfBoots;
    }

    /**
     * @param bundleOfBoots the bundleOfBoots to set
     */
    public void setBundleOfBoots(ArrayList<OrderItems> bundleOfBoots) {
        this.bundleOfBoots = bundleOfBoots;
    }
    
    public void addBoot(Boot boot) {
        boolean foundBoot = false;
        for(OrderItems eachItem : this.bundleOfBoots){
            if(eachItem.getBoot().getCode() == boot.getCode()){
                eachItem.upQuantity();
                eachItem.updateCost();
                foundBoot = true;
            }
        }
        if(boot != null && !foundBoot){
            this.bundleOfBoots.add(new OrderItems(boot));
        }
    }
   
    public void removeBoot(Boot boot) {
        for(int i = 0; i< this.bundleOfBoots.size(); i++){
        if(this.bundleOfBoots.get(i).getBoot().getCode() == boot.getCode()){
                this.bundleOfBoots.remove(i);
            }
        }
    }
    
    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        double total = 0;
        for(OrderItems eachItem : this.bundleOfBoots){
            eachItem.updateCost();
            total+=eachItem.getCost();
        }
        return total;
    }

    /**
     * @return the deliveryCost
     */
    public double getDeliveryCost() {
        return deliveryCost;
    }

    /**
     * @param deliveryCost the deliveryCost to set
     */
    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public void setBootQuantity(Boot boot, int quant) {
        for(int i = 0; i< this.bundleOfBoots.size(); i++){
            if(this.bundleOfBoots.get(i).getBoot().getCode() == boot.getCode()){
                this.bundleOfBoots.get(i).setQuantity(quant);
                this.bundleOfBoots.get(i).updateCost();
            }
        }
    }
    
    @Override
    public String toString() {
        return "Trolley{" +
                "bundleOfBoots=" + bundleOfBoots.toString() +
                ", totalPrice=" + getTotalPrice() +
                ", deliveryCost=" + deliveryCost +
                '}';
    }
}
