package currencyconverter;

import java.io.File;
import java.util.Scanner;

public class CurrencyTable {

    /**
     * The CurrencyTable class contains the methods to read the currency names and values
     * from the files currencies.txt and currenciesValues.txt.
     * The currency names are stored in the array currencyNames and the currency values
     * are stored in the array currencyValues.
     */

    private static float[] currencyValues; // Array to store the currency values
    private static String[] currencyNames; // Array to store the currency names
    private static  int currencyCount = 0; // Counter for the number of currencies

    /**
     * The method createCurrency() reads the currency names and values from the files currencies.txt
     * and currenciesValues.txt and stores the names in the array currencyNames and the values in the
     * array currencyValues.
     */
    public static void createCurrency() {


        try {
            File fileCurrencies = new File("C:\\Users\\abelj\\IdeaProjects\\Bonuspunkteprojekt\\src\\main\\java\\ff061\\ab327\\currencies.txt"); // Path of the file currencies.txt
            Scanner currenciesSc = new Scanner(fileCurrencies); // Scanner to read the file currencies.txt

            File fileValues = new File("C:\\Users\\abelj\\IdeaProjects\\Bonuspunkteprojekt\\src\\main\\java\\ff061\\ab327\\currenciesValues.txt"); // Path of the file currenciesValues.txt
            Scanner valuesSc = new Scanner(fileValues); // Scanner to read the file currenciesValues.txt

            while (currenciesSc.hasNextLine() ) { // While there is a next line
                currencyCount++;   // Count the number of currencies
                currenciesSc.nextLine(); // Read the next line
            }

            currencyValues = new float[currencyCount]; // Create the array currencyValues with the size of the number of currencies
            currencyNames = new String[currencyCount]; // Create the array currencyNames with the size of the number of currencies

            currenciesSc = new Scanner(fileCurrencies); // Create a new scanner to read the file currencies.txt


            for (int i = 0; i < currencyCount; i++) {
                currencyNames[i] = currenciesSc.nextLine(); // Read the currency names from the file currencies.txt and store them in the array currencyNames
                currencyValues[i] = Float.parseFloat(valuesSc.nextLine()); // Read the currency values from the file currenciesValues.txt and store them in the array currencyValues
            }

        } catch (Exception e) { // Catch the exception if the file could not be found
            e.printStackTrace();
        }
    }

    /**
     * The method getCurrencyNames() returns the array currencyNames.
     * @return currencyNames
     */
    public static String[] getCurrencyNames() {
        return currencyNames;
    }

    /**
     * The method getCurrencyValues() returns the array currencyValues.
     * @return currencyValues
     */
    public static float[] getCurrencyValues() {
        return currencyValues;
    }


}
