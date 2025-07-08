package helpers;

import com.github.javafaker.Faker;
import dto.gadget.Data;
import dto.gadget.Gadget;

public class GadgetTestDataHelper {
    static Faker faker = new Faker();
    public static Gadget createSampleGadget() {
        Gadget gadget = new Gadget();
        gadget.setName(faker.company().name() + " gadget");
        Data data = new Data();
        data.setYear((float) faker.number().randomDouble(2, 2010, 2020));
        data.setPrice((float) faker.number().randomDouble(2, 0, 1000));
        data.setCPUModel("Intel Core " + faker.number().numberBetween(1, 10));
        data.setHardDiskSize(faker.number().numberBetween(1, 100) + "TB");

        gadget.setData(data);
        return gadget;
    }
}
