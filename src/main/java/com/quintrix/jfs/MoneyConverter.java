/*
 * Converts from USD to the most commonly traded currencies in the world (per
 * https://www.investopedia.com/trading/most-tradable-currencies/). Currencies include: EUR, JPY,
 * GBP, CHF, CAD, AUD, and ZAR. Website used for conversion rates is
 * https://www.x-rates.com/table/?from=USD&amount=1 and was last accessed on 4/6/22. User may
 * interact with program through console entries.
 */


/*
 * TODO: - utilize free API to get updated conversion rates from USD to more currencies - add more
 * input validation - ask user if they would like to convert more values - show currency symbol in
 * results - develop a GUI or webpage for the user to interact with
 */

package com.quintrix.jfs;

import java.util.Scanner;

public class MoneyConverter {

  public static void main(String[] args) {
    System.out.println("Welcome to the Currency Converter!\n\n");
    System.out.println(
        "This program will convert USD to the following currencies:\n[1] Australian Dollar\n[2] British Pound\n[3] Canadian Dollar\n"
            + "[4] Euros\n[5] Japanese Yen\n[6] South African Rand\n[7] Swiss Franc");
    System.out.println(
        "\nPlease select one of the currencies listed above by entering the corresponding number (1-7): ");

    Scanner in = new Scanner(System.in);
    int userSelection;
    while (true) {
      try {
        userSelection = Integer.parseInt(in.nextLine());
        if (userSelection < 1 || userSelection > 7) {
          System.out.println(
              "Invalid selection. Please enter a number between 1 and 7 corresponding to the desired currency listed above:");
        } else
          break;
      } catch (NumberFormatException e) {
        System.out.println(
            "Invalid selection. Please enter a number between 1 and 7 corresponding to the desired currency listed above:");
      }
    }


    System.out
        .println("Please enter the amount you would like to convert (only enter numeric values): ");
    double moneyInput;
    while (true) {
      try {
        moneyInput = Double.parseDouble(in.nextLine());
        if (moneyInput > 0)
          break;
        else
          System.out.println("Invalid input. Please Enter a valid number.");
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please Enter a valid number.");
      }
    }

    double result = convertCurrency(userSelection, moneyInput);
    System.out.print("Result: ");
    System.out.format("%.2f", result);
    System.out.println(" ");
    in.close();
    System.out.println("Thank you for using the Currency Converter!");
  }

  private static double findCurrency(int userSelection) {
    double currencyCode;
    switch (userSelection) {
      case 1: // australian dollar
        currencyCode = 1.336859;
        break;
      case 2: // british pounds
        currencyCode = 0.765303;
        break;
      case 3: // canadian dollar
        currencyCode = 1.258517;
        break;
      case 4:// euros
        currencyCode = 0.919439;
        break;
      case 5:// japanese yen
        currencyCode = 123.976987;
        break;
      case 6:// south african rand
        currencyCode = 14.740445;
        break;
      case 7:// swiss franc
        currencyCode = 0.933861;
        break;
      default:
        currencyCode = 1;
        break;
    }
    return currencyCode;
  }

  private static double convertCurrency(int userSelection, double moneyInput) {
    double conversionValue = findCurrency(userSelection);
    double result = moneyInput * conversionValue;
    return result;
  }
}
