/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Model.User;

public class UserDAO {
    
    public static User getUserByEmail(String email){
        if(email.equals("user@gmail.com")){
            User user = new User();
            user.setPassword("user");
            user.setType("USER");
            user.setEmail("user@gmail.com");
            return user;
        }else if(email.equals("admin@gmail.com")){
            User admin = new User();
            admin.setType("ADMIN");
            admin.setPassword("admin");
            admin.setEmail("admin@gmail.com");
            return admin;
        }

        return null;
    }
   
}
