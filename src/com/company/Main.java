package com.company;

import java.text.DecimalFormat; // to gain access to number formatting
import java.util.Scanner; // to get user input

public class Main {

  public static void main(String[] args) {

    // TODO: enact enums to capture if self-employed or not

    double preTaxIncome;
    double postTaxIncome;
    // the below solution taken from: http://stackoverflow.com/questions/8895337/how-do-i-limit-the-number-of-decimals-printed-for-a-double
    DecimalFormat numberFormat = new DecimalFormat("#.00");

    System.out.println("Hello There, Friend!");
    System.out.println("What's your Annual Income?");

    try {
      Scanner scan = new Scanner(System.in);
      preTaxIncome = scan.nextInt();

      postTaxIncome = calculate(preTaxIncome);
      System.out.println("Your post-tax annual income would be: "+ numberFormat.format(postTaxIncome));
      System.out.println("This would be a monthly income of: "+ numberFormat.format(postTaxIncome / 12.0));
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
