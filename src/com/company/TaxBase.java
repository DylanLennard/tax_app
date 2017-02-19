package com.company;

/**
 * Created by dlennard09 on 2/19/17.
 */
public abstract class TaxBase {

  double [] taxBracket;
  double [] taxRates;

  public TaxBase(){}

  public void calculate(){

    int i = 0;

    for (i = 0; i < taxBracket.length; i++) {

      if (i == 0){
        continue;
      } else if (i <= taxBracket.length - 1){
        System.out.println(i);
      } else {
        System.out.println(i);
      }

    }

    // take two arrays and difference out the tax amounts appropriately

  }

}
