package org.example;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final String API_KEY = "YOUR_API_KEY";
    private static final String BASE_URL = "https://open.er-api.com/v6/latest/";

    private static final List<String> CURRENCY_CODES = Arrays.asList(
            "1. USD-American Dollar", "2. EUR-Euro", "3. GBP-British Pound", "4. JPY-Japanese Yen", "5. AUD-Australian Dollar",
            "6. CAD-Canadian Dollar", "7. CHF-Swiss Franc", "8. CNY-Chinese Yuan", "9. SEK-Swedish Krona", "10. NZD-New Zealand Dollar",
            "11. NOK-Norwegian Krone", "12. MXN-Mexican Peso", "13. SGD-Singapore Dollar", "14. HKD-Hong Kong Dollar", "15. TRY-Turkish Lira",
            "16. INR-Indian Rupee", "17. BRL-Brazilian Real", "18. ZAR-South African Rand", "19. RUB-Russian Ruble", "20. KRW-South Korean Won"
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- Currency Converter -----");
        CURRENCY_CODES.forEach(System.out::println);
        System.out.println();

        System.out.println("--- Base Currency ---");
        int baseCurrencyNumber = getUserInputNumber(scanner);
        String baseCurrency = getCurrencies().get(baseCurrencyNumber - 1);
        System.out.println();

        System.out.println("--- Target Currency ---");
        int targetCurrencyNumber = getUserInputNumber(scanner);
        String targetCurrency = getCurrencies().get(targetCurrencyNumber - 1);

        try {
            // Display exchange rate information
            displayExchangeRateInfo(baseCurrency, targetCurrency);

            System.out.println("Enter the amount of " + baseCurrency + " to convert: ");
            BigDecimal amountToConvert = scanner.nextBigDecimal();
            System.out.println();

            // Perform the currency conversion
            BigDecimal conversionResult = convertCurrency(baseCurrency, targetCurrency, amountToConvert);
            System.out.println(amountToConvert + " " + baseCurrency + " is equal to " + conversionResult + " " + targetCurrency);
        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getUserInputNumber(Scanner scanner) {
        int inputNumber;
        do {
            System.out.print("Number of Currency Code: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next(); // consume the invalid input
            }
            inputNumber = scanner.nextInt();
        } while (inputNumber < 1 || inputNumber > CURRENCY_CODES.size());
        return inputNumber;
    }

    private static void displayExchangeRateInfo(String baseCurrency, String targetCurrency)
            throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        URI uri = URI.create(BASE_URL + baseCurrency + "?apikey=" + API_KEY);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            System.out.println();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedTimestamp = now.format(formatter);
            System.out.println("Exchange rate as of " + formattedTimestamp);
            System.out.println("1 " + baseCurrency + " = " + getExchangeRate(responseBody, targetCurrency) +
                    " " + targetCurrency);
        } else {
            System.out.println("Failed to retrieve exchange rates. HTTP Status Code: " + response.statusCode());
        }
    }

    private static BigDecimal convertCurrency(String baseCurrency, String targetCurrency, BigDecimal amount)
            throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        URI uri = URI.create(BASE_URL + baseCurrency + "?apikey=" + API_KEY);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            String responseBody = response.body();
            BigDecimal exchangeRate = getExchangeRate(responseBody, targetCurrency);
            return amount.multiply(exchangeRate);
        } else {
            System.out.println("Failed to retrieve exchange rates. HTTP Status Code: " + response.statusCode());
            return BigDecimal.ZERO;
        }
    }

    private static BigDecimal getExchangeRate(String responseBody, String targetCurrency) {
        // Parse the JSON response to get the exchange rate for the target currency
        // This is a simplified example; you may want to use a JSON parsing library for production code
        String ratePrefix = "\"" + targetCurrency + "\":";
        int startIndex = responseBody.indexOf(ratePrefix) + ratePrefix.length();
        int endIndex = responseBody.indexOf(",", startIndex);
        String rateString = responseBody.substring(startIndex, endIndex).trim();

        return new BigDecimal(rateString);
    }

    private static List<String> getCurrencies() {
        List<String> currencyCodes = Arrays.asList("USD", "EUR", "GBP", "JPY", "AUD", "CAD", "CHF", "CNY", "SEK", "NZD",
                "NOK", "MXN", "SGD", "HKD", "TRY", "INR", "BRL", "ZAR", "RUB", "KRW");
        return currencyCodes;
    }
}
