package com.georgesykes.tilltechtest;

import java.util.Map;

public class ReceiptFactory {

  public Receipt getReceipt(Order order, Map shopDetails) {
    return new Receipt(order, shopDetails);
  }
}
