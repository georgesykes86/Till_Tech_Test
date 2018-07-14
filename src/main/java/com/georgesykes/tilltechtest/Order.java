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

  public Double getTotal() {
    return this.calculateSubTotal() + this.getTaxTotal();
  }

  public Double getTaxTotal() {
    return this.calculateSubTotal() * this.TAX;
  }

  public Collection<HashMap> getItems() {
    return this.itemList.getItems();
  }

  private Double calculateSubTotal() {
    Double subTotal = 0.0;
    for(HashMap item : this.getItems()) {
      Item itemDet = (Item) item.get("item");
      subTotal = ((int)item.get("quantity") * itemDet.getPrice()) + subTotal;
    }
    return subTotal;
  }
}
