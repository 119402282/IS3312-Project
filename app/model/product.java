public abstract class product {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected String description;
    protected String type;
    protected abstract String toFile();
}
//research different types of boot
//look at strategy method for use in UML
//look at decorator for same use
//also factory?

//look at