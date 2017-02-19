package com.company;

import java.util.Scanner; //used to get user input

public class Main {

  public static void main(String[] args) {

    double preTaxIncome;
    double postTaxIncome;

    System.out.println("Hello There, Friend!");
    System.out.println("What's your Annual Income?");

    // TODO: stick try catch statement in here
    Scanner scan = new Scanner(System.in);
    preTaxIncome = scan.nextInt();

    postTaxIncome = calculate(preTaxIncome);
    System.out.println(postTaxIncome);

  }

  public static double calculate(double preTaxIncome) {

    FederalTax fedIncome = new FederalTax(preTaxIncome);
    StateTax stateIncome = new StateTax(preTaxIncome);
    SocialSecurityTax ssTax = new SocialSecurityTax();
    MedicareTax medicareTax = new MedicareTax();

    fedIncome.calculate();
    stateIncome.calculate();
    ssTax.calculate();
    medicareTax.calculate();

    return preTaxIncome - (fedIncome.getTaxedIncome() + stateIncome.getTaxedIncome() +
                              ssTax.getTaxedIncome() + medicareTax.getTaxedIncome());

  }
}
