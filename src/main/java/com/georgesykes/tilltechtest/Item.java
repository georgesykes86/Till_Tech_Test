package com.georgesykes.tilltechtest;

import lombok.Data;

@Data
public class Item {
  private String name;
  private Double price;

  public Item(String name, Double price) {
    this.name = name;
    this.price = price;
  }

}
