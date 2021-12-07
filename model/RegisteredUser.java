package Model;
import java.util.ArrayList;


public class RegisteredUser extends User{
    public String getFullName() {
        return fullName;
    }

    protected String fullName;
    protected String Eircode;
    protected Trolley trolley;
    protected ArrayList<Trolley> orderHistory;

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String toJSON() {
        return null;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEircode() {
        return Eircode;
    }

    public void setEircode(String eircode) {
        Eircode = eircode;
    }

    public Trolley getTrolley() {
        return trolley;
    }

    public void setTrolley(Trolley trolley) {
        this.trolley = trolley;
    }

    public ArrayList<Trolley> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Trolley> orderHistory) {
        this.orderHistory = orderHistory;
    }
}
