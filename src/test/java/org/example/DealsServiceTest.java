package org.example;

import Models.Deal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DealsServiceTest {

    @Test
    public void testProcessDeal() {
        MongoDatabase database = MongoDBConnection.getDatabase();
        DealsService dealsService = new DealsService(database);
        Deal deal = new Deal();

        deal.setDealUniqueId("999");
        deal.setFromCurrencyIsoCode("JOD");
        deal.setToCurrencyIsoCode("SA");
        deal.setDealAmount(9999);
        deal.setDealTimestamp(LocalDateTime.now());

        dealsService.saveDeal(deal);
    }
}
