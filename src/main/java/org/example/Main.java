package org.example;


import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Models.Deal;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        MongoDatabase database = MongoDBConnection.getDatabase();
        DealsService dealsService = new DealsService(database);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter Deal Unique ID (or '*' to finish): ");
                String dealUniqueId = scanner.nextLine();
                if (dealUniqueId.equals("*")) {
                    break; // Exit the loop if user inputs '*'
                }

                System.out.print("Enter From Currency ISO Code: ");
                String fromCurrencyIsoCode = scanner.nextLine();

                System.out.print("Enter To Currency ISO Code: ");
                String toCurrencyIsoCode = scanner.nextLine();

                System.out.print("Enter Deal Timestamp (e.g., 2023-07-16T19:20): ");
                String dealTimestampStr = scanner.nextLine();
                LocalDateTime dealTimestamp = LocalDateTime.parse(dealTimestampStr);

                System.out.print("Enter Deal Amount: ");
                double dealAmount = Double.parseDouble(scanner.nextLine());

                Deal deal = new Deal();
                deal.setDealUniqueId(dealUniqueId);
                deal.setFromCurrencyIsoCode(fromCurrencyIsoCode);
                deal.setToCurrencyIsoCode(toCurrencyIsoCode);
                deal.setDealTimestamp(dealTimestamp);
                deal.setDealAmount(dealAmount);

                dealsService.saveDeal(deal);
                logger.info("Deal processed successfully");

            } catch (DateTimeParseException e) {
                logger.error("Invalid date format. Please use the format yyyy-MM-ddTHH:mm", e);
            } catch (NumberFormatException e) {
                logger.error("Invalid number format for deal amount", e);
            } catch (Exception e) {
                logger.error("An error occurred while processing the deal", e);
            }
        }

        MongoDBConnection.close();
        scanner.close();
        logger.info("Application terminated.");
    }
}