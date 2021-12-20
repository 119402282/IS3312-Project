/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Model.User;

/**
 *
 * @author culle
 */
public class LoginUtil {
    
    public static boolean approveLogin(String email, String password, User user){
        return email.equals(user.getEmail()) && password.equals(user.getPassword());
    }
    
    public static String loginType(User user){
        if(user == null){
            return null;
        } else {
            return "\""+user.getType() + "\"";
        }
    }
}
