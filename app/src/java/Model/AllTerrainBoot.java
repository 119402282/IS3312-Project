package Model;

public class AllTerrainBoot extends Boot {

    public AllTerrainBoot() {
        type = "forest";
    }

    public AllTerrainBoot(int code, String name, String description, double size, String color, double price, String brand) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.type = "forest";
        this.size = size;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "StreetBoot{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                "}";
    }

    @Override
    public String toJSON() {
        return "{\n" +
                "\"code\": \"" + code + "\",\n" +
                "\"name\": \"" + name + "\",\n" +
                "\"description\": \"" + description + "\",\n" +
                "\"type\": \"" + type + "\",\n" +
                "\"size\": \"" + size + "\",\n" +
                "\"color\": \"" + color + "\",\n" +
                "\"price\": \"" + price + "\",\n" +
                "\"brand\": \"" + brand + "\"\n" +
                "}";
    }
}
