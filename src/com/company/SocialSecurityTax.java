package com.company;

/**
 * Created by dlennard09 on 2/19/17.
 */
public class SocialSecurityTax extends TaxBase {
  /*
  $127,200 is the limit at which no more of the income is contributed towards the amount
  https://www.ssa.gov/news/press/factsheets/colafacts2017.pdf
   */
  private final static double SOCIAL_SECURITY_RATE       = 0.062;
  private final static double SOCIAL_SECURITY_MAX_INCOME = 127_200;

  public SocialSecurityTax() {}
  public SocialSecurityTax(double income) {super(income);}

  @Override
  public void calculate() {

    if (getPreTaxIncome() < SOCIAL_SECURITY_MAX_INCOME) {

      adjustTaxedIncome(getPreTaxIncome() * SOCIAL_SECURITY_RATE);

    } else {

      adjustTaxedIncome(SOCIAL_SECURITY_MAX_INCOME * SOCIAL_SECURITY_RATE);

    }
  }
}
