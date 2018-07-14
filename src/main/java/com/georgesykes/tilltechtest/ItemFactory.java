package com.georgesykes.tilltechtest;

public class ItemFactory {

  public Item getItem(String name, Float price) {
    return new Item(name, price);
  }

}
