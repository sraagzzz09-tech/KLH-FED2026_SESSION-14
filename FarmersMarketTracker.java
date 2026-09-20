public class FarmersMarketTracker {

    // Calculates the total quantity sold for one product.
    public static int calculateTotalSold(int[] dailySales) {
        int totalSold = 0;

        for (int day = 0; day < dailySales.length; day++) {
            totalSold = totalSold + dailySales[day];
        }

        return totalSold;
    }

    // Calculates income earned from one product.
    public static double calculateRevenue(int quantitySold, double pricePerKg) {
        return quantitySold * pricePerKg;
    }

    // Displays whether the remaining stock is sufficient.
    public static void displayStockStatus(int remainingStock) {
        if (remainingStock == 0) {
            System.out.println("Stock Status   : OUT OF STOCK");
        } else if (remainingStock <= 10) {
            System.out.println("Stock Status   : LOW STOCK");
        } else {
            System.out.println("Stock Status   : SUFFICIENT STOCK");
        }
    }

    // Displays whether the selling price is low, moderate, or high.
    public static void displayPriceCategory(double price) {
        if (price < 30) {
            System.out.println("Price Category : Low");
        } else if (price <= 60) {
            System.out.println("Price Category : Moderate");
        } else {
            System.out.println("Price Category : High");
        }
    }

    // Finds the product that earned the highest revenue using a while loop.
    public static int findHighestRevenueProduct(double[] revenue) {
        int highestIndex = 0;
        int index = 1;

        while (index < revenue.length) {
            if (revenue[index] > revenue[highestIndex]) {
                highestIndex = index;
            }
            index++;
        }

        return highestIndex;
    }

    // Displays the daily sales stored in a two-dimensional array.
    public static void displayDailySales(String[] products, int[][] sales) {
        System.out.println("\n========== THREE-DAY SALES ==========");
        System.out.printf("%-12s %-8s %-8s %-8s%n",
                "Product", "Day 1", "Day 2", "Day 3");

        for (int product = 0; product < products.length; product++) {
            System.out.printf("%-12s", products[product]);

            for (int day = 0; day < sales[product].length; day++) {
                System.out.printf(" %-8d", sales[product][day]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Data types and one-dimensional arrays
        String farmerName = "Green Valley Farm";
        String[] products = {"Tomato", "Potato", "Carrot", "Onion"};
        double[] pricePerKg = {42.50, 28.00, 55.00, 36.50};
        int[] quantityProduced = {100, 120, 80, 110};
        double[] revenue = {0.0, 0.0, 0.0, 0.0};

        // Two-dimensional array: rows represent products and columns represent days.
        int[][] dailySales = {
                {25, 30, 20},
                {35, 40, 25},
                {20, 18, 22},
                {30, 28, 32}
        };

        boolean marketOpen = true;
        char currencySymbol = 'R';
        int totalQuantitySold = 0;
        double totalMarketRevenue = 0.0;

        System.out.println("==============================================");
        System.out.println("   FARMERS' MARKET PRICE AND SALES TRACKER");
        System.out.println("==============================================");
        System.out.println("Farmer/Market : " + farmerName);
        System.out.println("Market Open   : " + marketOpen);
        System.out.println("Currency Code : " + currencySymbol + "s (Rupees)");

        displayDailySales(products, dailySales);

        System.out.println("\n========== PRODUCT-WISE REPORT ==========");

        int product = 0;

        // A do-while loop displays at least one product report.
        do {
            int sold = calculateTotalSold(dailySales[product]);
            int remaining = quantityProduced[product] - sold;
            double productRevenue = calculateRevenue(sold, pricePerKg[product]);

            revenue[product] = productRevenue;
            totalQuantitySold += sold;
            totalMarketRevenue += productRevenue;

            System.out.println("\nProduct        : " + products[product]);
            System.out.printf("Price per kg   : Rs. %.2f%n", pricePerKg[product]);
            System.out.println("Quantity Ready : " + quantityProduced[product] + " kg");
            System.out.println("Quantity Sold  : " + sold + " kg");
            System.out.println("Stock Left     : " + remaining + " kg");
            System.out.printf("Revenue        : Rs. %.2f%n", productRevenue);

            displayPriceCategory(pricePerKg[product]);
            displayStockStatus(remaining);

            product++;
        } while (product < products.length);

        int bestProduct = findHighestRevenueProduct(revenue);

        System.out.println("\n============= FINAL SUMMARY =============");
        System.out.println("Total Quantity Sold : " + totalQuantitySold + " kg");
        System.out.printf("Total Revenue       : Rs. %.2f%n", totalMarketRevenue);
        System.out.println("Top-Earning Produce : " + products[bestProduct]);
        System.out.printf("Highest Revenue     : Rs. %.2f%n", revenue[bestProduct]);

        if (totalMarketRevenue >= 10000) {
            System.out.println("Overall Performance : Excellent sales");
        } else if (totalMarketRevenue >= 5000) {
            System.out.println("Overall Performance : Good sales");
        } else {
            System.out.println("Overall Performance : Sales need improvement");
        }

        System.out.println("==========================================");
    }
}
