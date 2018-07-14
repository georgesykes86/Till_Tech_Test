package com.georgesykes.tilltechtest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Order {
  private CustomerDetails customerDetails;
  private ItemList itemList;

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

  public Object getTaxTotal() {
    return "String";
  }

  public Collection<HashMap> getItems() {
    return new ArrayList<>();
  }
}
