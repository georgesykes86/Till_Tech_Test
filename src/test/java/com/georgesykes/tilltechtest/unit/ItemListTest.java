package com.georgesykes.tilltechtest.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes.tilltechtest.Item;
import com.georgesykes.tilltechtest.ItemFactory;
import com.georgesykes.tilltechtest.ItemList;
import com.georgesykes.tilltechtest.ItemListFactory;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@TestInstance(Lifecycle.PER_CLASS)
public class ItemListTest {
  private ItemList list;
  private ItemListFactory itemListFactory = new ItemListFactory();
  private final HashMap menu = new HashMap();

  @Mock
  private ItemFactory factory;

  @Mock
  private Item item;

  @BeforeAll
  public void before() {
    menu.put("Coffee", 1.00);
  }

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(factory.getItem("Coffee", 1.00)).thenReturn(item);
    list = itemListFactory.getItemList(menu, factory);
    list.addItem("Coffee", 1);
  }

  @Test
  public void addsNewItem() {
    assertEquals(1, list.getItems().size());
  }

  @Test
  public void addsItemToItemHash() {
    HashMap firstItem = (HashMap) list.getItems().get(0);
    assertEquals(item, firstItem.get("item"));
  }

  @Test
  public void addsCorectQuantity() {
    HashMap firstItem = (HashMap) list.getItems().get(0);
    assertEquals(1, firstItem.get("quantity"));
  }


}
