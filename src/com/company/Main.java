package com.company;

import java.util.Scanner; //used to get user input

public class Main {

  public static void main(String[] args) {

    // TODO: enact enums to capture if self-employed or not

    double preTaxIncome;
    double postTaxIncome;

    System.out.println("Hello There, Friend!");
    System.out.println("What's your Annual Income?");

    try {
      Scanner scan = new Scanner(System.in);
      preTaxIncome = scan.nextInt();

      postTaxIncome = calculate(preTaxIncome);
      System.out.println(postTaxIncome);
    } catch (Exception e){
      System.out.println(e.getMessage());
    }


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
