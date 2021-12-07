package data;

import Model.Boot;
import Model.BootFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BootIO {

    public static Boot getBoot(int code, String path) {
        try {
            File file = new File(path);
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = input.readLine();
            while (line != null) {
                String[] list = line.split("\\|");
                int productCode = Integer.parseInt(list[0]);
                if (code == productCode) {
                    return new BootFactory().createBoot(list);
                }
                line = input.readLine();
            }
            input.close();
            return null;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    public static ArrayList<Boot> getAllBoots(String path) {
        ArrayList<Boot> boots = new ArrayList<Boot>();
        File file = new File(path);
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = input.readLine();
            BootFactory bootMaker = new BootFactory();
            while (line != null) {
                String[] list = line.split("\\|");
                Boot b = bootMaker.createBoot(list);
                boots.add(b);
                line = input.readLine();
            }
            input.close();
            return boots;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

}
