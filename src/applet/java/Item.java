public class Item {
    private String id, name, description, type;

    public Item(String setName) {
        this.name = setName;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setId(String newID) {
        id = newID;
    }

    public String getId() {
        return id;
    }

    public void setDescription(String newDescription ) {
        description = newDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String newType) {
        type = newType;
    }

    public String getType() {
        return type;
    }
}
