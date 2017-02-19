package com.company;

/**
 * Created by dlennard09 on 2/19/17.
 */
public class StateTax extends TaxBase{
  // https://www.tax-brackets.org/californiataxtable
  //TODO: Refactor to have this info be relative to state, be dynamic, and come from database

  private final static double [] STATE_BRACKETS = {7_850, 18_610, 29_372, 40_773,
                                                    51_530, 263_222, 315_866, 526_443, 1_000_000};
  private final static double [] STATE_RATES    = {0.01, 0.02, 0.04, 0.06, 0.08, 0.093, 0.103, 0.113, 0.123, 0.133};

  public StateTax(){
    super(STATE_RATES, STATE_BRACKETS);
  }
  public StateTax(double preTaxIncome){
    super(preTaxIncome, STATE_RATES, STATE_BRACKETS);
  }



}
