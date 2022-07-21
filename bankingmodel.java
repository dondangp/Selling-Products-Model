package bankingmodel;

//Product Selling Model
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bankingmodel {

    private int[] arrayUnit;
    private float[] arrayPrice;

    public bankingmodel() {
    }

    public bankingmodel(int[] arrayUnit, float[] arrayPrice) {
        this.arrayUnit = arrayUnit;
        this.arrayPrice = arrayPrice;
    }

    public double getTotal() {
        double moneySoldSmallSize = arrayUnit[0] * arrayPrice[0];
        double moneySoldMediumSize = arrayUnit[1] * arrayPrice[1];
        double moneySoldLargeSize = arrayUnit[2] * arrayPrice[2];

        double subtotal = moneySoldSmallSize + moneySoldMediumSize + moneySoldLargeSize;
        double tax = subtotal * 8.25 / 100;
        double total = subtotal + tax;

        return total;
    }

    public String getCurrentDate() {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public void printReceipt(int transaction, double moneyPaid) {

        double moneySoldSmallSize = arrayUnit[0] * arrayPrice[0];
        double moneySoldMediumSize = arrayUnit[1] * arrayPrice[1];
        double moneySoldLargeSize = arrayUnit[2] * arrayPrice[2];

        double subtotal = moneySoldSmallSize + moneySoldMediumSize + moneySoldLargeSize;
        double tax = subtotal * 8.25 / 100;
        double total = subtotal + tax;

        System.out.printf("File SU2022SaleProductSU_Application_Sharda.java\n");
        System.out.printf("SU2022 Sale Product SU Receipt - ROHIT SHARDA\n");
        System.out.printf("Day:%s  - Transaction #: %4d\n", getCurrentDate(), transaction);
        System.out.printf("-------------------------------------------\n");
        System.out.printf("SMALL  (%5.2f) %7d %14.2f\n", arrayPrice[0], arrayUnit[0], moneySoldSmallSize);
        System.out.printf("MEDIUM (%5.2f) %7d %14.2f\n", arrayPrice[1], arrayUnit[1], moneySoldMediumSize);
        System.out.printf("LARGE  (%5.2f) %7d %14.2f\n", arrayPrice[2], arrayUnit[2], moneySoldLargeSize);
        System.out.printf("-------------------------------------------\n");
        System.out.printf("Subtotal: %27.2f\n", subtotal);
        System.out.printf("Tax: %32.2f\n", tax);
        System.out.printf("Total: %30.2f\n", total);
        System.out.printf("Money Paid: %25.2f\n", moneyPaid);
        System.out.printf("Change: %29.2f\n", moneyPaid - total);
    }

    public void toFile(String fileName, int transaction) {
        try {
            PrintWriter writer = new PrintWriter(new File(fileName));
            writer.printf("%d %d %d %d\n", transaction, arrayUnit[0], arrayUnit[1], arrayUnit[2]);
            writer.close();
        } catch (IOException e) {
        }
    }

    public void printReport(String day) {

        double moneySoldSmallSize = arrayUnit[0] * arrayPrice[0];
        double moneySoldMediumSize = arrayUnit[1] * arrayPrice[1];
        double moneySoldLargeSize = arrayUnit[2] * arrayPrice[2];

        double subtotal = moneySoldSmallSize + moneySoldMediumSize + moneySoldLargeSize;
        double tax = subtotal * 8.25 / 100;
        double total = subtotal + tax;

        System.out.printf("Product Seller\n");
        System.out.printf("SALE PRODUCT SU REPORT - Don Dang\n");
        System.out.printf("Day Report:               %s\n", day);
        System.out.printf("-------------------------------------------\n");
        System.out.printf("SMALL  (%5.2f) %7d %14.2f\n", arrayPrice[0], arrayUnit[0], moneySoldSmallSize);
        System.out.printf("MEDIUM (%5.2f) %7d %14.2f\n", arrayPrice[1], arrayUnit[1], moneySoldMediumSize);
        System.out.printf("LARGE  (%5.2f) %7d %14.2f\n", arrayPrice[2], arrayUnit[2], moneySoldLargeSize);
        System.out.printf("-------------------------------------------\n");
        System.out.printf("Subtotal: %27.2f\n", subtotal);
        System.out.printf("Tax: %32.2f\n", tax);
        System.out.printf("Total: %30.2f\n", total);

    }

    public void compareTwoDays(bankingmodel other, String day1, String day2) {

        double moneySoldSmallSize1 = arrayUnit[0] * arrayPrice[0];
        double moneySoldMediumSize1 = arrayUnit[1] * arrayPrice[1];
        double moneySoldLargeSize1 = arrayUnit[2] * arrayPrice[2];

        double subtotal1 = moneySoldSmallSize1 + moneySoldMediumSize1 + moneySoldLargeSize1;
        double tax1 = subtotal1 * 8.25 / 100;
        double total1 = subtotal1 + tax1;

        double moneySoldSmallSize2 = other.arrayUnit[0] * other.arrayPrice[0];
        double moneySoldMediumSize2 = other.arrayUnit[1] * other.arrayPrice[1];
        double moneySoldLargeSize2 = other.arrayUnit[2] * other.arrayPrice[2];

        double subtotal2 = moneySoldSmallSize1 + moneySoldMediumSize1 + moneySoldLargeSize1;
        double tax2 = subtotal2 * 8.25 / 100;
        double total2 = subtotal2 + tax2;

        System.out.printf("Banking Model\n");
        System.out.printf("SALE PRODUCT SU COMPARE DAYS REPORT - Don Dang\n");
        System.out.printf("COMPARE DAYS:     %s and %s\n", day1, day2);
        System.out.printf("--------------------------------------------------------------------------------------------");
        System.out.printf("                    SALE IN %s      SALE IN %s   DIFFERENCE   PERCENTAGE\n", day1, day2);
        System.out.printf("SMALL  ($%5.2f)     %6d %11.2f      %6d %11.2f   %10d   %9.2f%%\n", arrayPrice[0], arrayUnit[0], moneySoldSmallSize1, other.arrayUnit[0], moneySoldSmallSize2, 0, 0.0);
        System.out.printf("MEDIUM ($%5.2f)     %6d %11.2f      %6d %11.2f   %10d   %9.2f%%\n", arrayPrice[1], arrayUnit[1], moneySoldMediumSize1, other.arrayUnit[1], moneySoldMediumSize2, 0, 0.0);
        System.out.printf("LARGE  ($%5.2f)     %6d %11.2f      %6d %11.2f   %10d   %9.2f%%\n", arrayPrice[2], arrayUnit[2], moneySoldLargeSize1, other.arrayUnit[2], moneySoldLargeSize2, 0, 0.0);
        System.out.printf("--------------------------------------------------------------------------------------------");
        System.out.printf("Subtotal: %27.2f %23.2f\n", subtotal1, subtotal2);
        System.out.printf("Tax: %32.2f %23.2f\n", tax1, tax2);
        System.out.printf("Total: %30.2f %23.2f\n", total1, total2);

    }

}

