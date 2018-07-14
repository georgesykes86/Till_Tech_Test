package com.georgesykes.tilltechtest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Order {
  private CustomerDetails customerDetails;
  private ItemList itemList;
  private final Double TAX = 0.2;

  public Order(CustomerDetails details, ItemList list){
    this.customerDetails = details;
    this.itemList = list;
  }

  public void addItem(String item, int quantity) {
    this.itemList.addItem(item, quantity);
  }

  public int getTableNum() {
    return this.customerDetails.getTableNum();
  }

  public int getPeopleNum() { return this.customerDetails.getNumPeople(); }

  public Object getTotal() {
    return "String";
  }

  public Double getTaxTotal() {
    Double totalTax = 0.0;
    for(HashMap item : this.getItems()) {
      Item itemDet = (Item) item.get("item");
      totalTax = this.TAX * ((int)item.get("quantity") * itemDet.getPrice()) + totalTax;
    }
    return totalTax;
  }

  public Collection<HashMap> getItems() {
    return this.itemList.getItems();
  }
}
