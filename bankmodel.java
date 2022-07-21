package bankingmodel;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bankmodel{

    static Scanner scanner = new Scanner(System.in);
    static int transaction = 1;

    public static void main(String[] args) {

        float[] arrayPrice = new float[]{11.29f, 12.79f, 13.59f};

        while (true) {
            printMainMenu();
            System.out.printf("Enter a number from 1 to 3 to select a task: ");

            int choice = scanner.nextInt();
            System.out.println();
            if (choice == 1) {
                saleProduct(arrayPrice);
                transaction++;
            } else if (choice == 2) {
                endingDaySaleReport(arrayPrice);
            } else if (choice == 3) {
                compareSales(arrayPrice);
            } else if (choice == 0) {
                break;
            }
        }
    }

    public static void printMainMenu() {
        System.out.printf("Product Seller\n");
        System.out.printf("PRODUCT SU SHOP MAIN MENU - Don Dang\n");
        System.out.printf("Current Date: %s\n", (new bankingmodel()).getCurrentDate());
        System.out.printf("-----------------------------------------------\n");
        System.out.printf("1.	Sale Product SU\n");
        System.out.printf("2.	Ending Day Sale Report\n");
        System.out.printf("3.	Compare Sale In Two Days Report\n");
        System.out.printf("0.	Exit\n");
    }

    public static void printSubMenu(float[] arrayPrice) {
        System.out.printf("Banking Model\n");
        System.out.printf("PRODUCT SU MENU - Don Dang");
        System.out.printf("Today: %s\n", "");
        System.out.printf("-----------------------------\n");
        System.out.printf("1.SMALL  - $%.2f\n", arrayPrice[0]);
        System.out.printf("2.MEDIUM - $%.2f\n", arrayPrice[1]);
        System.out.printf("3.LARGE  - $%.2f\n", arrayPrice[2]);
        System.out.printf("0.Exit\n");
    }

    public static void saleProduct(float[] arrayPrice) {
        int[] arrayUnit = new int[]{0, 0, 0};
        while (true) {
            printSubMenu(arrayPrice);
            System.out.printf("Enter a number from 1 to 3 to select product size: ");
            int choice2 = scanner.nextInt();
            System.out.println();
            if (choice2 == 1) {
                System.out.print("Enter number of units to add: ");
                arrayUnit[0] += scanner.nextInt();
            } else if (choice2 == 2) {
                System.out.print("Enter number of units to add: ");
                arrayUnit[1] += scanner.nextInt();
            } else if (choice2 == 3) {
                System.out.print("Enter number of units to add: ");
                arrayUnit[2] += scanner.nextInt();
            } else if (choice2 == 0) {
                bankingmodel object = new bankingmodel(arrayUnit, arrayPrice);
                System.out.println("Total charge of the order = " + object.getTotal());
                System.out.print("Enter amount to pay: ");
                double moneyPaid = scanner.nextDouble();
                System.out.println();
                object.printReceipt(transaction, moneyPaid);
                object.toFile("daySale_" + object.getCurrentDate() + ".txt", transaction);
                transaction++;
                System.out.println();
                break;
            }
        }
    }

    public static void endingDaySaleReport(float[] arrayPrice) {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine().trim();
        while (fileName.length() == 0) {
            fileName = scanner.nextLine().trim();
        }
        String day = fileName.substring(8, 16);
        day = day.substring(0, 2) + "/" + day.substring(2, 4) + "/" + day.substring(4, 8);
        int[] arrayTotalUnit = new int[]{0, 0, 0};
        try {
            Scanner file = new Scanner(new File(fileName));
            while (file.hasNext()) {
                String[] data = file.nextLine().split(" ");
                arrayTotalUnit[0] += Integer.valueOf(data[1]);
                arrayTotalUnit[1] += Integer.valueOf(data[2]);
                arrayTotalUnit[2] += Integer.valueOf(data[3]);
            }
            file.close();
        } catch (FileNotFoundException ex) {
        }
        bankingmodel object = new bankingmodel(arrayTotalUnit, arrayPrice);
        System.out.println();
        object.printReport(day);
        System.out.println();
    }

    public static void compareSales(float[] arrayPrice) {
        System.out.print("Enter first file name: ");
        String fileName1 = scanner.nextLine().trim();
        while (fileName1.length() == 0) {
            fileName1 = scanner.nextLine().trim();
        }
        String day1 = fileName1.substring(8, 16);
        day1 = day1.substring(0, 2) + "/" + day1.substring(2, 4) + "/" + day1.substring(4, 8);

        System.out.print("Enter second file name: ");
        String fileName2 = scanner.nextLine().trim();
        while (fileName2.length() == 0) {
            fileName2 = scanner.nextLine().trim();
        }
        String day2 = fileName2.substring(8, 16);
        day2 = day2.substring(0, 2) + "/" + day2.substring(2, 4) + "/" + day2.substring(4, 8);

        int[] arrayTotalUnit1 = new int[]{0, 0, 0};
        try {
            Scanner file = new Scanner(new File(fileName1));
            while (file.hasNext()) {
                String[] data = file.nextLine().split(" ");
                arrayTotalUnit1[0] += Integer.valueOf(data[1]);
                arrayTotalUnit1[1] += Integer.valueOf(data[2]);
                arrayTotalUnit1[2] += Integer.valueOf(data[3]);
            }
            file.close();
        } catch (FileNotFoundException ex) {
        }
        bankingmodel object1 = new bankingmodel(arrayTotalUnit1, arrayPrice);

        int[] arrayTotalUnit2 = new int[]{0, 0, 0};
        try {
            Scanner file = new Scanner(new File(fileName2));
            while (file.hasNext()) {
                String[] data = file.nextLine().split(" ");
                arrayTotalUnit2[0] += Integer.valueOf(data[1]);
                arrayTotalUnit2[1] += Integer.valueOf(data[2]);
                arrayTotalUnit2[2] += Integer.valueOf(data[3]);
            }
            file.close();
        } catch (FileNotFoundException ex) {
        }
        bankingmodel object2 = new bankingmodel(arrayTotalUnit2, arrayPrice);
        System.out.println();
        object1.compareTwoDays(object2, day1, day2);
        System.out.println();
    }

}
