package com.company;

import java.util.Scanner; //used to get user input

public class Main {

  public static void main(String[] args) {

    double preTaxIncome;
    double postTaxIncome;

    System.out.println("Hello There, Friend!");
    System.out.println("What's your Annual Income?");

    // stick try catch in here
    Scanner scan = new Scanner(System.in);
    preTaxIncome = scan.nextInt();

    postTaxIncome = calculate(preTaxIncome);
    System.out.println(postTaxIncome);

  }

  public static double calculate(double preTaxIncome) {

    FederalTax fedIncome = new FederalTax(preTaxIncome);
    StateTax stateIncome = new StateTax(preTaxIncome);

    fedIncome.calculate();
    stateIncome.calculate();

    return preTaxIncome - (fedIncome.getTaxedIncome() + stateIncome.getTaxedIncome());

  }
}
