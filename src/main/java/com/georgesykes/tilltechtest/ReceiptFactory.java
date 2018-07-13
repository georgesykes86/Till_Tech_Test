package com.georgesykes.tilltechtest;

import java.util.HashMap;

public class ReceiptFactory {

  public Receipt getReceipt(Order order, HashMap shopDetails) {
    return new Receipt(order, shopDetails);
  }
}
