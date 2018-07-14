package com.georgesykes.tilltechtest;

import java.util.Map;

public class Receipt {
  private Order order;
  private Map shopDetails;

  public Receipt(Order order, Map shopDetails) {
    this.order = order;
    this.shopDetails = shopDetails;
  }

  @Override
  public String toString() {
    return this.addHeader() + this.addItems() + this.addTotal();
  }

  private String addHeader() {
    return String.format("%s\n\n%s\nPhone: %s\nTable: %d / [%d]\n",
        this.shopDetails.get("shopName"), this.shopDetails.get("address"),
        this.formatPhoneNum((String) this.shopDetails.get("phone")),
        this.order.getTableNum(), this.order.getPeopleNum());
  }

  private String addItems() {
    String returnString = "";
    for(Map entry : order.getItems()) {
      Item item = (Item) entry.get("item");
      returnString = returnString + String.format("\t%s      \t\t%d x %.02f\n",
          item.getName(), entry.get("quantity"), item.getPrice());
    }
    return returnString;
  }

  private String addTotal() {
    return String.format("Tax  \t\t\t\t\t\t\t\t\t£%.02f\nTotal\t\t\t\t\t\t\t\t\t£%.02f",
        this.order.getTaxTotal(), this.order.getTotal());
  }

  private String formatPhoneNum(String num) {
    return String.format("+%s (%s) %s", num.substring(0,2), num.substring(2,6), num.substring(6));
  }

}
