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
    double postTaxIncome = preTaxIncome;

    TaxBase [] taxes = {
      new FederalTax(preTaxIncome),
        new StateTax(preTaxIncome),
        new SocialSecurityTax(preTaxIncome),
        new MedicareTax(preTaxIncome)
    };

    for (TaxBase tax: taxes){
      tax.calculate();
      postTaxIncome = postTaxIncome - tax.getTaxedIncome();
    }

    return postTaxIncome;

  }
}
