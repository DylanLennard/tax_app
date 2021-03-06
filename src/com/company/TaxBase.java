package com.company;


/**
 * Created by dlennard09 on 2/19/17.
 */
public abstract class TaxBase {

  private double [] taxBrackets;
  private double [] taxRates;
  private double preTaxIncome;
  private double taxedIncome;

  public TaxBase(){}
  public TaxBase(double income){setPreTaxIncome(income);}

  public TaxBase(double [] taxRates, double [] taxBrackets) {
    setTaxRates(taxRates);
    setTaxBracket(taxBrackets);
  }
  public TaxBase(double income, double [] taxRates, double [] taxBracket) {
    setPreTaxIncome(income);
    setTaxRates(taxRates);
    setTaxBracket(taxBracket);
  }

  public void setPreTaxIncome(double preTaxIncome) {this.preTaxIncome = preTaxIncome;}
  public void setTaxBracket(double [] taxBracket) {this.taxBrackets = taxBracket.clone();}
  public void setTaxRates(double [] taxRates) {this.taxRates = taxRates.clone();}

  public double getPreTaxIncome() {return this.preTaxIncome;}
  public double [] getTaxRates() {return this.taxRates;}
  public double [] getTaxBracket() {return this.taxBrackets;}

  public void adjustTaxedIncome(double value) {this.taxedIncome += value;}
  public double getTaxedIncome() {return this.taxedIncome;}

  public void calculate() {

    int i = 0;

    for (i = 0; i < taxBrackets.length; i++) {

      if (i == 0){

        if (preTaxIncome >taxBrackets[i]) {
          adjustTaxedIncome(taxBrackets[i] * taxRates[i]);
        } else {
          adjustTaxedIncome(preTaxIncome * taxRates[i]);
          break;
        }

      } else if ((preTaxIncome > taxBrackets[i]) && (i == taxBrackets.length  - 1)) {
        adjustTaxedIncome(preTaxIncome - taxBrackets[i] * taxRates[i + 1]);
      } else if (preTaxIncome >= taxBrackets[i]){
        adjustTaxedIncome((taxBrackets[i] - taxBrackets[i-1]) * taxRates[i]);
      } else {
        adjustTaxedIncome((preTaxIncome - taxBrackets[i - 1]) * taxRates[i]);
        break;
      }
    }
  }
}
