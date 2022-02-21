package Model;

import java.util.ArrayList;

public class User {

    private String email;
    private String password;
    private String type;
    private String fullName;        
    private String eircode;
    private Trolley trolley;
    private ArrayList<Trolley> orderHistory;
    
    public User(){
        this.orderHistory = new  ArrayList<Trolley>();
        this.trolley = new Trolley();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getType() {
        if(type == null){
            return "";
        } else {
            return type;
        }
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
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
