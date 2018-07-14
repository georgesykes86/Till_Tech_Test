package com.georgesykes.tilltechtest;

import java.util.Map;

public class Till {
  private OrderFactory orderFactory;
  private ReceiptFactory receiptFactory;
  private Printer printer;
  private Order order;
  private Map shopDetails;
  private MenuParser parser;
  private ItemListFactory ilFactory;
  private ItemFactory itemFactory;
  private CustomerDetailsFactory customerDetailsFactory;

  public Till(ReceiptFactory receiptFactory, OrderFactory orderFactory, Printer printer, MenuParser parser,
      ItemListFactory ilFactory, ItemFactory itemFactory, CustomerDetailsFactory cdf) {
    this.receiptFactory = receiptFactory;
    this.orderFactory = orderFactory;
    this.printer = printer;
    this.order = null;
    this.shopDetails = parser.getShopDetails();
    this.parser = parser;
    this.ilFactory = ilFactory;
    this.itemFactory = itemFactory;
    this.customerDetailsFactory = cdf;
  }

  public void addTable(int tableNum, int numPeople) {
    ItemList list = this.ilFactory.getItemList(this.parser.getMenu(), this.itemFactory);
    CustomerDetails details = this.customerDetailsFactory.getCustomerDetails(tableNum, numPeople);
    this.order = orderFactory.getOrder(details, list);
  }

  public void addItem(String item, int quantity) {
    this.order.addItem(item, quantity);
  }

  public void printReceipt() {
    printer.print(receiptFactory.getReceipt(this.order, this.shopDetails));
  }
}
