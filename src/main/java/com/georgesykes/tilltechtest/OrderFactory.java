package com.georgesykes.tilltechtest;

import java.util.HashMap;

public class OrderFactory {

  public Order getOrder(HashMap menu) {
    return new Order(menu);
  }
}
