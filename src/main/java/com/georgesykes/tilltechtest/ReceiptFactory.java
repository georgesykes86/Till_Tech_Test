package com.georgesykes.tilltechtest;

public class ReceiptFactory {

  public Receipt getReceipt(Order order) {
    return new Receipt(order);
  }
}
