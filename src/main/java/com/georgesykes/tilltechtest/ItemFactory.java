package com.georgesykes.tilltechtest;

public class ItemFactory {

  public Item getItem(String name, Double price) {
    return new Item(name, price);
  }

}
