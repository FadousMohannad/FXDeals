package org.example;

import Models.Deal;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Optional;

public class DealsService {
    private static final Logger logger = LoggerFactory.getLogger(DealsService.class);
    private final MongoCollection<Document> collection;

    public DealsService(MongoDatabase database) {
        this.collection = database.getCollection("deals");
    }

    public void saveDeal(Deal deal) {
        if (dealExists(deal.getDealUniqueId())) {
            logger.warn("Deal with ID {} already exists", deal.getDealUniqueId());
            return;
        }
        Document document = new Document("dealUniqueId", deal.getDealUniqueId())
                .append("fromCurrencyIsoCode", deal.getFromCurrencyIsoCode())
                .append("toCurrencyIsoCode", deal.getToCurrencyIsoCode())
                .append("dealTimestamp", deal.getDealTimestamp().toString())
                .append("dealAmount", deal.getDealAmount());
        collection.insertOne(document);
        logger.info("Deal with ID {} inserted successfully", deal.getDealUniqueId());
    }

    private boolean dealExists(String dealUniqueId) {
        Document query = new Document("dealUniqueId", dealUniqueId);
        Optional<Document> existingDeal = Optional.ofNullable(collection.find(query).first());
        return existingDeal.isPresent();
    }
}
