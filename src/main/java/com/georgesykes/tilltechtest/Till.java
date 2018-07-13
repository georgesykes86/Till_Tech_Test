package com.georgesykes.tilltechtest;

import java.util.HashMap;

public class Till {
  private OrderFactory orderFactory;
  private ReceiptFactory receiptFactory;
  private Printer printer;
  private Order order;
  private HashMap shopDetails;

  public Till(ReceiptFactory receiptFactory, OrderFactory orderFactory, Printer printer, MenuParser parser) {
    this.receiptFactory = receiptFactory;
    this.orderFactory = orderFactory;
    this.printer = printer;
    this.order = null;
    this.shopDetails = parser.getShopDetails();
  }

  public void addTable(int tableNum, int numPeople) {
    this.order = orderFactory.getOrder();
    this.order.updateCustomerDetails(tableNum, numPeople);
  }

  public void addItem(String item, int quantity) {
    this.order.addItem(item, quantity);
  }

  public void printReceipt() {
    printer.print(receiptFactory.getReceipt(this.order), this.shopDetails);
  }
}
