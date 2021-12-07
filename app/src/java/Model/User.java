package Model;

public abstract class User {

    protected String email;
    protected String password;
    protected String type;
    
    public abstract String toString();
    public abstract String toJSON();

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
}
