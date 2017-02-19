package com.company;

/**
 * Created by dlennard09 on 2/19/17.
 */
public class FederalTax extends TaxBase{

  //http://www.cpapracticeadvisor.com/news/12262495/projected-2017-income-tax-rates-and-brackets for rates
  //TODO: Refactor to be responsive to a database

  private final static double [] FED_BRACKETS = {9_325, 37_950, 91_900, 191_650, 416_700, 418_400};
  private final static double [] FED_RATES    = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35, 0.39};

  // add field for self-employed or not
  public FederalTax(){
    super(FED_RATES, FED_BRACKETS);
  }
  public FederalTax(double preTaxIncome){
    super(preTaxIncome, FED_RATES, FED_BRACKETS);
  }
}
