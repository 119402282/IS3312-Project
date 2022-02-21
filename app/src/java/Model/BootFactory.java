package Model;

public class BootFactory implements Cobbler {
    @Override
    public Boot createBoot(int code, String name, String type, String description, int size, String color, double price, String brand) {
        type = type.toLowerCase();
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
            case "street":
                return new StreetBoot(code, name, description, size, color, price, brand);
            default:
                return null;
        }
    }
}
