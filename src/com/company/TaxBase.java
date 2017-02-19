package com.company;


/**
 * Created by dlennard09 on 2/19/17.
 */
public abstract class TaxBase {

  private double [] taxBrackets;
  private double [] taxRates;
  private double preTaxIncome;

//  public TaxBase(){}
//  public TaxBase (double income){
//    setIncome(income);
//  }
  public TaxBase(double [] taxRates, double [] taxBrackets){
    setTaxRates(taxRates);
    setTaxBracket(taxBrackets);
  }
  public TaxBase(double income, double [] taxRates, double [] taxBracket){
    setPreTaxIncome(income);
    setTaxRates(taxRates);
    setTaxBracket(taxBracket);
  }


  public void setPreTaxIncome(double preTaxIncome){
    this.preTaxIncome = preTaxIncome;
  }
  public void setTaxBracket(double [] taxBracket){
    this.taxBrackets = taxBracket.clone(); //make this an equals method or something
  }
  public void setTaxRates(double [] taxRates){
    this.taxRates = taxRates.clone();
  }

  public double getPreTaxIncome() {return this.preTaxIncome;}
  public double [] getTaxRates(){return this.taxRates;}
  public double [] getTaxBracket(){return this.taxBrackets;}


  public void calculate(){

    int i = 0;

    for (i = 0; i < taxBrackets.length; i++) {

      if (preTaxIncome < taxBrackets[i]){

      }

    }

    // take two arrays and difference out the tax amounts appropriately

  }

}
