package com.georgesykes.tilltechtest;

import java.util.Map;

public class Till {
  private OrderFactory orderFactory;
  private ReceiptFactory receiptFactory;
  private Printer printer;
  private Order order;
  private Map shopDetails;
  private MenuParser parser;

  public Till(ReceiptFactory receiptFactory, OrderFactory orderFactory, Printer printer, MenuParser parser) {
    this.receiptFactory = receiptFactory;
    this.orderFactory = orderFactory;
    this.printer = printer;
    this.order = null;
    this.shopDetails = parser.getShopDetails();
    this.parser = parser;
  }

  public void addTable(int tableNum, int numPeople) {
//    this.order = orderFactory.getOrder(this.parser.getMenu());
//    this.order.updateCustomerDetails(tableNum, numPeople);
  }

  public void addItem(String item, int quantity) {
    this.order.addItem(item, quantity);
  }

  public void printReceipt() {
    printer.print(receiptFactory.getReceipt(this.order, this.shopDetails));
  }
}
