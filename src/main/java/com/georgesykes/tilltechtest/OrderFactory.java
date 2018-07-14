package com.georgesykes.tilltechtest;

public class OrderFactory {

  public Order getOrder(CustomerDetails details, ItemList list) {
    return new Order(details, list);
  }
}
