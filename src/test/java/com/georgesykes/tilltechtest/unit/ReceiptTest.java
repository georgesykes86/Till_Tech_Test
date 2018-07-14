package com.georgesykes.tilltechtest.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.georgesykes.tilltechtest.Item;
import com.georgesykes.tilltechtest.Order;
import com.georgesykes.tilltechtest.Receipt;
import com.georgesykes.tilltechtest.ReceiptFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@TestInstance(Lifecycle.PER_CLASS)
public class ReceiptTest {
  private Receipt receipt;
  private ReceiptFactory factory = new ReceiptFactory();
  private final HashMap shopDetails = new HashMap();
  private List firstOrders = new ArrayList();

  @Mock
  private Order firstOrder;

  @Mock
  private Item firstItem;

  @BeforeAll
  public void setUpDetails() {
    shopDetails.put("shopName", "The Coffee Connection");
    shopDetails.put("address", "123 Lakeside Way");
    shopDetails.put("phone", "441220360070");
  }

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    firstOrders.add(new HashMap(){{
      put("item", firstItem);
      put("quantity", 1);
    }});
    when(firstItem.getName()).thenReturn("Coffee");
    when(firstItem.getPrice()).thenReturn(1.00f);
    when(firstOrder.getTableNum()).thenReturn(1);
    when(firstOrder.getPeopleNum()).thenReturn(4);
    when(firstOrder.getItems()).thenReturn(firstOrders);
    when(firstOrder.getTotal()).thenReturn(1.20);
    when(firstOrder.getTaxTotal()).thenReturn(0.2);
    receipt = factory.getReceipt(firstOrder, shopDetails);
  }

  private String firstReceiptString = "The Coffee Connection\n\n123 Lakeside Way\nPhone: +44 (1220) 360070\n"
      + "Table: 1 / [4]\n\tCoffee      \t\t1 x 1.00\n"
      + "Tax  \t\t\t\t\t\t\t\t\t£0.20\nTotal\t\t\t\t\t\t\t\t\t£1.20";

  @Test
  public void returnsStringFormatReceipt() {
    assertEquals(firstReceiptString, receipt.toString());
  }

}
