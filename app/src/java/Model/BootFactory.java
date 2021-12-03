package Model;

public class BootFactory implements Cobbler {
    @Override
    public Boot createBoot(String[] props) {

        int code = Integer.parseInt(props[0]);
        String name = props[1];
        String type = props[2];
        String description = props[3];
        int size = Integer.parseInt(props[4]);
        String color = props[5];
        double price = Double.parseDouble(props[6]);
        String brand = props[7];

        switch(type) {
            case "wellington":
                return new GardenBoot(code, name, description, size, color, price, brand);
            case "snow":
                return new SnowBoot(code, name, description, size, color, price, brand);
            case "forest":
                return new AllTerrainBoot(code, name, description, size, color, price, brand);
            case "water":
                return new SailingBoot(code, name, description, size, color, price, brand);
            case "fashion":
                return new StreetBoot(code, name, description, size, color, price, brand);
            default:
                return null;
        }
    }
}
