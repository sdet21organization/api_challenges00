package tests;

import dto.gadget.Gadget;
import helpers.GadgetTestDataHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import wrappers.ApiWrapper;

public class GadgetTest extends GadgetBaseTest {
    @Test
    public void createGadgetTest() {
        Gadget gadgetToCreate = GadgetTestDataHelper.createSampleGadget();
        Gadget createdGadget = ApiWrapper.createGadget(gadgetToCreate);
        Assertions.assertEquals(gadgetToCreate, createdGadget);
    }
}
