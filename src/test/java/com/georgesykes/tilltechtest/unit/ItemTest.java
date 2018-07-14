package com.georgesykes.tilltechtest.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.georgesykes.tilltechtest.Item;
import com.georgesykes.tilltechtest.ItemFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {
  private Item item;
  private ItemFactory factory = new ItemFactory();
  private String name = "Coffee";
  private Float price = 2.50f;

  @BeforeEach
  public void setUp() {
    item = factory.getItem(name, price);
  }

  @Test
  public void returnName() {
    assertEquals(name, item.getName());
  }

}
