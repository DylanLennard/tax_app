package com.company;

/**
 * Created by dlennard09 on 2/19/17.
 */
public class MedicareTax extends TaxBase{
  /*
  Medicare tax is 1.45% up to $200,000, and then 2.35% after that
  https://www.ssa.gov/news/press/factsheets/colafacts2017.pdf
  */

  private final static double MEDICARE_RATE = 0.0145;
  private final static double MEDICARE_INCREASE_INCOME = 200_000;

  public MedicareTax(){}
  public MedicareTax(double income) {super(income);}

  @Override
  public void calculate(){

    if (getPreTaxIncome() <= MEDICARE_INCREASE_INCOME){

      adjustTaxedIncome(getPreTaxIncome() * MEDICARE_RATE);

    } else {

      adjustTaxedIncome(MEDICARE_INCREASE_INCOME * MEDICARE_RATE);
      adjustTaxedIncome(getPreTaxIncome() - MEDICARE_INCREASE_INCOME * (MEDICARE_RATE + 0.009));

    }
  }
}
