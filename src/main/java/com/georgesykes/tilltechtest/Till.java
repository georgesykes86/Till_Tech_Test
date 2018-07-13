package com.georgesykes.tilltechtest;

public class Till {
  private OrderFactory orderFactory;
  private ReceiptFactory receiptFactory;
  private Printer printer;
  private Order order;

  public Till(ReceiptFactory receiptFactory, OrderFactory orderFactory, Printer printer) {
    this.receiptFactory = receiptFactory;
    this.orderFactory = orderFactory;
    this.printer = printer;
    this.order = null;
  }

  public void addTable(int tableNum, int numPeople) {
    this.order = orderFactory.getOrder();
    this.order.updateCustomerDetails(tableNum, numPeople);
  }

  public void addItem(String item, int quantity) {
    this.order.addItem(item, quantity);
  }

  public void printReceipt() {
    Receipt receipt = receiptFactory.getReceipt(this.order);
  }
}
