package com.ame.ame.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatNumberToPrice {
  public static String formatterPrice(double price) {
    Locale locale = new Locale("pt", "BR");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
    return currencyFormatter.format(price);
  }
}
