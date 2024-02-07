package amalitech;

import amalitech.calculator.Mortgage;
import amalitech.screen.AnnualRateScreen;
import amalitech.screen.PrincipalScreen;
import amalitech.screen.ScreenAction;
import amalitech.screen.YearScreen;

import java.text.NumberFormat;

/**
 * Building A Mortgage Calculator
 * Requirement Specs:
 * 1. Principal:100000
 * 2.Annual Interest Rates:4.2
 * 3. Period(Years):30
 * 4. Mortgage:$?
 * 5.
 */
public class MortgageCalculator {
    public static void main(String[] args) {
        /**
         * TODO 1: Incorporate down payment
         * TODO 2: Country based mortgage calculation
         * TODO 3: Country taxes that affect mortgage
         * TODO 4: Home owners insurance
         * TODO 5: Private Mortgage Insurance (PMI)
         * TODO 6: Incorporate database to allow storage of multiple calculated mortgages
         * TODO : A Spring version of program once all add ons are done
         */



        ScreenAction screenType = new PrincipalScreen();
        Mortgage mortgageClass = new Mortgage();

        System.out.println(
                """
                ********** Welcome To Kingsley's Mortgage Calculator **********
                          *********** Follow the prompt *************
                """
        );
        screenType.askForContent();
        screenType.takeContent();
        int principal = (int) screenType.manipulateContent();

        screenType = new AnnualRateScreen();
        screenType.askForContent();
        screenType.takeContent();
        double monthlyInterest = screenType.manipulateContent();

        screenType = new YearScreen();
        screenType.askForContent();
        screenType.takeContent();
        int numberOfPayments = (int) screenType.manipulateContent();

        double mortgage = mortgageClass.calculateMortgage(principal, monthlyInterest, numberOfPayments);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.printf("->>>>> Mortgage payment per month : %s%n", mortgageFormatted);
    }
}