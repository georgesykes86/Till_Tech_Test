package com.georgesykes.tilltechtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemList {
  private ItemFactory factory;
  private Map menu;
  private ArrayList<Map> items;

  public ItemList(Map menu, ItemFactory factory) {
    this.factory = factory;
    this.menu = menu;
    this.items = new ArrayList();
  }

  public void addItem(String item, int quantity) {
    HashMap entry = new HashMap();
    entry.put("item", this.factory.getItem(item, (float) this.menu.get(item)));
    this.items.add(entry);
  }

  public ArrayList getItems() {
    return this.items;
  }
}
