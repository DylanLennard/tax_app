package com.company;

/**
 * Created by dlennard09 on 2/19/17.
 */
public class MedicareTax {
  /*
  Medicare tax is 1.45% up to $200,000, and then 2.35% after that
  https://www.ssa.gov/news/press/factsheets/colafacts2017.pdf
  */

  private final static double MEDICARE_RATE = 1.45;
  private final static double MEDICARE_INCREASE_INCOME = 200_000;
  private double income;
  private double taxedIncome;

  public MedicareTax(){}
  public MedicareTax(double income) {setIncome(income);}

  public void setIncome(double income) {this.income = income;}
  public double getIncome() {return this.income;}

  public void adjustTaxedIncome(double value) {this.taxedIncome += value;}
  public double getTaxedIncome() {return this.taxedIncome;}

  public void calculate(){

    if (income <= MEDICARE_INCREASE_INCOME){

      adjustTaxedIncome(getIncome() * MEDICARE_RATE);

    } else {

      adjustTaxedIncome(MEDICARE_INCREASE_INCOME * MEDICARE_RATE);
      adjustTaxedIncome(getIncome() - MEDICARE_INCREASE_INCOME * (MEDICARE_RATE + 0.009));
    }

  }

}
