package Model;

public class OrderItems {
    private Boot boot;
    private int quantity;
    private double cost;

    public OrderItems(Boot boot){
        this.boot = boot;
        this.quantity = 1;
        this.cost = this.quantity * boot.price;
    }
    
    public Boot getBoot() {
        return boot;
    }

    public void setBoot(Boot boot) {
        this.boot = boot;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void upQuantity() {
        this.quantity += 1;
    }
    
    public void downQuantity() {
        this.quantity -=1;
    }
    
    public double getCost() {
        updateCost();
        return cost;
    }

    public void updateCost() {
        this.cost = this.boot.price*this.quantity;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "boot=" + boot.getName() +
                ", quantity=" + getQuantity() +
                ", cost=" + getCost() +
                '}';
    }
}
