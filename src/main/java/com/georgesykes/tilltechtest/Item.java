package com.georgesykes.tilltechtest;

import lombok.Data;

@Data
public class Item {
  private String name;
  private Float price;

  public Item(String name, Float price) {
    this.name = name;
    this.price = price;
  }

}
