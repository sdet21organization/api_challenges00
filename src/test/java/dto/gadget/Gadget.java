package dto.gadget;

import java.util.Objects;

public class Gadget {
    private String id;
    private String name;
    Data DataObject;
    private String createdAt;

    // Getter Methods

    public String getName() {
        return name;
    }

    public Data getData() {
        return DataObject;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setData(Data dataObject) {
        this.DataObject = dataObject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gadget gadget = (Gadget) o;
        return getName().equals(gadget.getName()) && getData().equals(gadget.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
