package com.georgesykes.tilltechtest;

import java.util.Map;

public class ItemListFactory {

  public ItemList getItemList(Map menu, ItemFactory factory) {
    return new ItemList(menu, factory);
  }

}
