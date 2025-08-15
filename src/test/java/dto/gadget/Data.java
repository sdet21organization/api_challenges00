package dto.gadget;

import java.util.Objects;

public class Data {
    private float year;
    private float price;
    private String CPUModel;
    private String HardDiskSize;

    // Getter Methods

    public float getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public String getCPUModel() {
        return CPUModel;
    }

    public String getHardDiskSize() {
        return HardDiskSize;
    }

    // Setter Methods

    public void setYear(float year) {
        this.year = year;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCPUModel(String CPUModel) {
        this.CPUModel = CPUModel;
    }

    public void setHardDiskSize(String HardDiskSize) {
        this.HardDiskSize = HardDiskSize; // Hard disk size = Hard disk size;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Float.compare(year, data.year) == 0 && Float.compare(price, data.price) == 0 && Objects.equals(CPUModel, data.CPUModel) && Objects.equals(HardDiskSize, data.HardDiskSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, price, CPUModel, HardDiskSize);
    }
}
