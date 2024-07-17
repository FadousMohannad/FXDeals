package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MainClassTest {

    @Test
    void testMain() {
        // Create a new DealService
        DealsServiceTest dealsService = new DealsServiceTest();
        dealsService.testProcessDeal();
    }

}