package Model;

public class Guest extends User {

    //this will be used if we want to track user activity for people who do not have a user account
    //We could use this together with a cookie to try and track them and remember their cart content
    //before they even register/login

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String toJSON() {
        return null;
    }
}
