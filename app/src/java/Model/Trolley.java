package Model;

import java.util.ArrayList;

public class Trolley {

    private ArrayList<OrderItems> bundleOfBoots;
    private double totalPrice;
    private double deliveryCost;
    /**
     * @return the bundleOfBoots
     */
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
        for(OrderItems eachItem : this.bundleOfBoots){
            if(eachItem.getBoot().getCode() == boot.getCode()){
                eachItem.upQuantity();
                eachItem.updateCost();
            }
        }
        if(boot != null){
            this.bundleOfBoots.add(new OrderItems(boot));
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
}
