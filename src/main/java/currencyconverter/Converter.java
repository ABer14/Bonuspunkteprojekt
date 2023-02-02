package currencyconverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Converter {

    /**
     * The methode contains the method converterRun() to start the currency converter.
     */
    public static void converterRun() {

        System.out.println("Welcome to the currency converter!"); // Welcome message
        System.out.println("Please choose one of the following options:"); // Ask the user to choose one of the following options
        System.out.println("GO || Start converting your currencies"); // Option 1: Start converting your currencies
        System.out.println("EXIT || Exit the currency converter"); // Option 404: Exit
        System.out.print("Your choice: " + "\n" ); // Ask the user to enter his choice
        Scanner scanner = new Scanner(System.in); // Scanner to read the user input
        String choice = scanner.next(); // Read the user input
        switch (choice.toUpperCase()) { // Switch case to choose between the options
            case "GO" ->{ // If the user enters GO run loop through the following methods
                Converter.buyCurrency();
                Converter.sellCurrency();
                Converter.currencyConverter();
                converterRun();}

            case "EXIT" -> System.out.println("\n" + "Thank you for using the currency converter!"); // If the user enters EXIT print the following message
            default -> {  // If the user enters something else print the following message
                System.out.println("\n" + "Please only enter GO and STOP!"); // Print the following message
                Converter.converterRun(); // Run the method converterRun() again
            }
        }
    }



    /**
     * The Converter class contains the methods to buy, sell and convert currencies.
     */
    private static int indexBuy ;
    private static int indexSell ;

    /**
     * The method buyCurrency() asks the user to enter the name of the currency he wants to buy.
     * The method searches the array currencyNames for the entered currency name and stores the index of the currency name in the array
     * in the variable indexBuy.
     */

    public static void buyCurrency() {

        Scanner stringScanner = new Scanner(System.in); // Scanner to read the user input
        System.out.print("Please enter the name of the currency you want to buy: "); // Ask the user to enter the name of the currency he wants to buy
        String userInput = stringScanner.next(); // Read the user input

        ArrayList<String> userInputCurrencies = new ArrayList<>(); // Create an ArrayList to store the currency names that contain the user input

        for (int i = 0; i < CurrencyTable.getCurrencyNames().length; i++) { // Loop through the array currencyNames
            if (CurrencyTable.getCurrencyNames()[i].toUpperCase().contains(userInput.toUpperCase())) {  // If the currency name contains the user input
                userInputCurrencies.add(CurrencyTable.getCurrencyNames()[i]);  // Add the currency name to the ArrayList userInputCurrencies
            }

        }
        String[] userInputArray = userInputCurrencies.toArray(userInputCurrencies.toArray(new String[0])); // Convert the ArrayList userInputCurrencies to an array


        if (userInputArray.length == 1) { // If the array userInputArray contains only one currency name
            while (!(Arrays.equals(userInputArray[0].toCharArray(), CurrencyTable.getCurrencyNames()[indexBuy].toCharArray()))) {  // While the currency name in the array userInputArray is not equal to the currency name in the array currencyNames
                indexBuy++; // Increase the index of the currency name in the array currencyNames
            }

        } else if (userInputArray.length > 1) { // If the array userInputArray contains more than one currency name

            for (int i = 0; i < userInputCurrencies.size(); i++) { // Loop through the array userInputCurrencies
                System.out.println(i + " : " + userInputCurrencies.get(i)); // Print the index and the currency name
            }
            Scanner choiceScanner = new Scanner(System.in);  // Scanner to read the user input
            System.out.print("Please enter the number of the currency you want to buy: "); // Ask the user to enter the number of the currency he wants to buy
            int userChoice = Integer.parseInt(choiceScanner.next()); // Read the user input

            while (userChoice > userInputCurrencies.size()) { // If the user input is greater than the size of the array userInputCurrencies
                System.out.print("This entry was false.Please enter the number of the currency you want to buy: "); // Ask the user to enter the number of the currency he wants to buy
                userChoice = Integer.parseInt(choiceScanner.next()); // Read the user input
            }
            while (!(Arrays.equals(userInputArray[userChoice].toCharArray(), CurrencyTable.getCurrencyNames()[indexBuy].toCharArray()))) { // While the currency name in the array userInputArray is not equal to the currency name in the array currencyNames
                indexBuy++; // Increase the index of the currency name in the array currencyNames
            }


        } else {
            System.out.println("Currency could not  be found"); // If the array userInputArray contains no currency name
            buyCurrency(); // Call the method buyCurrency() again
        }


        System.out.println("You have chosen to buy  " + CurrencyTable.getCurrencyNames()[indexBuy]); // Print the currency name the user has chosen to buy
    }


    /**
     * The method getIndexBuy() returns the int of the index buy generated in buyCurrency.
     * @return getIndexBuy
     */
    public static int getIndexBuy() {

        return indexBuy;
    }


    public static void sellCurrency() {

        Scanner stringScanner = new Scanner(System.in);  // Scanner to read the user input
        System.out.print("Please enter the name of the currency you want to sell: "); // Ask the user to enter the name of the currency he wants to sell
        String userInput = stringScanner.next(); // Read the user input

        ArrayList<String> userInputCurrencies = new ArrayList<>(); // Create an ArrayList to store the currency names that contain the user input

        for (int i = 0; i < CurrencyTable.getCurrencyNames().length; i++) { // Loop through the array currencyNames
            if (CurrencyTable.getCurrencyNames()[i].toUpperCase().contains(userInput.toUpperCase())) { // If the currency name contains the user input
                userInputCurrencies.add(CurrencyTable.getCurrencyNames()[i]); // Add the currency name to the ArrayList userInputCurrencies
            }

        }
        String[] userInputArray = userInputCurrencies.toArray(userInputCurrencies.toArray(new String[0])); // Convert the ArrayList userInputCurrencies to an array


        if (userInputArray.length == 1) { // If the array userInputArray contains only one currency name
            while (!(Arrays.equals(userInputArray[0].toCharArray(), CurrencyTable.getCurrencyNames()[indexSell].toCharArray()))) { // While the currency name in the array userInputArray is not equal to the currency name in the array currencyNames
                indexSell++; // Increase the index of the currency name in the array currencyNames
            }

        } else if (userInputArray.length > 1) { // If the array userInputArray contains more than one currency name

            for (int i = 0; i < userInputCurrencies.size(); i++) { // Loop through the array userInputCurrencies
                System.out.println(i + " : " + userInputCurrencies.get(i)); // Print the index and the currency name
            }
            Scanner choiceScanner = new Scanner(System.in);  // Scanner to read the user input
            System.out.print("Please enter the number of the currency you want to buy: "); // Ask the user to enter the number of the currency he wants to buy
            int userChoice = Integer.parseInt(choiceScanner.next()); // Read the user input

            while (userChoice > userInputCurrencies.size()) { // If the user input is greater than the size of the array userInputCurrencies
                System.out.print("This entry was false.Please enter the number of the currency you want to buy: "); // Ask the user to enter the number of the currency he wants to buy
                userChoice = Integer.parseInt(choiceScanner.next()); // Read the user input
            }
            while (!(Arrays.equals(userInputArray[userChoice].toCharArray(), CurrencyTable.getCurrencyNames()[indexSell].toCharArray()))) { // While the currency name in the array userInputArray is not equal to the currency name in the array currencyNames
                indexSell++; // Increase the index of the currency name in the array currencyNames
            }


        } else { // If the array userInputArray contains no currency name
            System.out.println("Currency could not  be found"); // Print the currency name the user has chosen to buy
            sellCurrency(); // Call the method sellCurrency() again
        }

        System.out.println("You have chosen to sell  " + CurrencyTable.getCurrencyNames()[indexSell]); // Print the currency name the user has chosen to sell
    }
    /**
     * The method getIndexSell() returns the int of the index sell generated in sellCurrency.
     * @return getIndexSell
     */
    public static int getIndexSell() {
        return indexSell;
    }

    /**
     * The method currencyConverter() converts the currency the user wants to buy into the currency the user wants to sell.
     */

    public static void currencyConverter() {

        Scanner floatScanner = new Scanner(System.in);  // Scanner to read the user input
        System.out.print("\n" + "Please enter the amount you want to buy : ");// Ask the user to enter the amount he wants to buy
        float userInput = 0;
        try {
            userInput = Float.parseFloat(floatScanner.next());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            currencyConverter();

        }

        float sdrSellAmount = userInput / CurrencyTable.getCurrencyValues()[getIndexBuy()]; // Calculate the amount of SDRs the user will receive

        float buyAmount = sdrSellAmount * CurrencyTable.getCurrencyValues()[getIndexSell()]; // Calculate the amount of the currency the user wants to buy the user will receive

        System.out.println("\n" + "To buy " + userInput + " " + CurrencyTable.getCurrencyNames()[getIndexBuy()]); // Print the amount the user wants to buy
        System.out.println("You have to sell: " + buyAmount + " " + CurrencyTable.getCurrencyNames()[getIndexSell()] + "\n"); // Print the amount the user will have to sell
    }
}
