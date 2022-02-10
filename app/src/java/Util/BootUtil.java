/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Model.Boot;
import java.util.ArrayList;

/**
 *
 * @author culle
 */
public class BootUtil {
    private final ArrayList<Boot> bootList;
    
   public BootUtil(ArrayList<Boot> list){
       this.bootList = list;
   }
    
    public Boot getBootByCode(int code){
        for(Boot eachBoot : bootList){
            if(eachBoot.getCode() == code){
                return eachBoot;
            }
        }
        return null;
    }
    
    public ArrayList<Boot> typeBoots(String type){
        ArrayList<Boot> filteredBoots = new ArrayList<Boot>();
        for(Boot eachBoot : bootList){
            if(eachBoot.getType().equals(type)){
                filteredBoots.add(eachBoot);
            }
        }
        return filteredBoots;
    }
    
    public ArrayList<Boot> nameSearchBoots(String name){
        ArrayList<Boot> filteredBoots = new ArrayList<Boot>();
        for(Boot eachBoot : bootList){
            if(eachBoot.getName().replaceAll("\\s", "").contains(name)){
                filteredBoots.add(eachBoot);
            }
        }
        return filteredBoots;
    } 
}
