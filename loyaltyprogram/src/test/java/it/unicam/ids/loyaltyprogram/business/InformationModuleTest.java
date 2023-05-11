package it.unicam.ids.loyaltyprogram.business;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InformationModuleTest {

    @Test
    void checkParameters() {
        HashMap<String,String> map = new HashMap<>();
        String name = "TestName";
        String description = "Description";
        map.put("name",name);
        map.put("description",description);
        InformationModule module = new InformationModule(map);
        assertTrue(module.checkParameters());
        InformationModule moduleEmpty = new InformationModule();
        assertFalse(moduleEmpty.checkParameters());
    }
}