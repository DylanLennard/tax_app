package com.company;

/**
 * Created by dlennard09 on 2/19/17.
 */
public class SocialSecurityTax {
  /*
  $127,200 is the limit at which no more of the income is contributed towards the amount
  https://www.ssa.gov/news/press/factsheets/colafacts2017.pdf
   */
  private final static double SOCIAL_SECURITY_RATE       = 6.2;
  private final static double SOCIAL_SECURITY_MAX_INCOME = 127_200;
  private double income;
  private double taxedIncome;

  public SocialSecurityTax() {}

  public SocialSecurityTax(double income) {setIncome(income);}

  public void setIncome(double income) {this.income = income;}

  public double getIncome() {return this.income;}

  public void adjustTaxedIncome(double value) {this.taxedIncome += value;}

  public double getTaxedIncome() {return this.taxedIncome;}

  public void calculate() {

    if (income < SOCIAL_SECURITY_MAX_INCOME) {

      adjustTaxedIncome(getIncome() * SOCIAL_SECURITY_RATE);

    } else {

      adjustTaxedIncome(SOCIAL_SECURITY_MAX_INCOME * SOCIAL_SECURITY_RATE);

    }
  }


}
