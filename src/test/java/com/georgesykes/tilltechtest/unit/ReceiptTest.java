package com.georgesykes.tilltechtest.unit;

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

@TestInstance(Lifecycle.PER_CLASS)
public class ReceiptTest {
  private Receipt receipt;
  private ReceiptFactory factory;
  private final HashMap shopDetails = new HashMap();
  private List orders = new ArrayList();

  @Mock
  private Order order;

  @Mock
  private Item firstItem;

  @Mock
  private Item secondItem;

  @BeforeAll
  public void setUpDetails() {
    shopDetails.put("shopName", "The Coffee Connection");
    shopDetails.put("address", "123 Lakeside Way");
    shopDetails.put("phone", "441220360070");
  }

  @BeforeEach
  public void setUp() {
    when(firstItem.getName()).thenReturn("Coffee");
  }

  @Test
  public void returnsStringFormatReceipt() {
    receipt = factory.getReceipt(order, shopDetails);
  }

}
