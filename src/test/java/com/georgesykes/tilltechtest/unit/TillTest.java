package com.georgesykes.tilltechtest.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.georgesykes.tilltechtest.MenuParser;
import com.georgesykes.tilltechtest.Order;
import com.georgesykes.tilltechtest.OrderFactory;
import com.georgesykes.tilltechtest.Printer;
import com.georgesykes.tilltechtest.Receipt;
import com.georgesykes.tilltechtest.ReceiptFactory;
import com.georgesykes.tilltechtest.Till;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@TestInstance(Lifecycle.PER_CLASS)
public class TillTest {
  private Till till;
  private HashMap<String, String> shopDetails;

  @Mock
  private OrderFactory orderFactory;

  @Mock
  private Order order;

  @Mock
  private ReceiptFactory receiptFactory;

  @Mock
  private Receipt receipt;

  @Mock
  private Printer printer;

  @Mock
  private MenuParser parser;

  @BeforeAll
  public void setUpShopDetails() {
    shopDetails = new HashMap();
    shopDetails.put("shopName", "The Coffee Connection");
    shopDetails.put("address", "123 Lakeside Way");
    shopDetails.put("phone", "441220360070");
  }

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(orderFactory.getOrder(any())).thenReturn(order);
    when(receiptFactory.getReceipt(any(), any())).thenReturn(receipt);
    when(parser.getShopDetails()).thenReturn(shopDetails);
    till = new Till(receiptFactory, orderFactory, printer, parser);
    till.addTable(1,4);
  }

  @Test
  public void addsTableDetails() {
    verify(order).updateCustomerDetails(1,4);
  }

  @Test
  public void addsItemToOrder() {
    till.addItem("Cafe Latte", 1);
    verify(order).addItem("Cafe Latte", 1);
  }

  @Test
  public void generatesReceipt() {
    till.printReceipt();
    verify(receiptFactory).getReceipt(order, shopDetails);
  }

  @Test
  public void printsReceipt() {
    till.printReceipt();
    verify(printer).print(receipt);
  }


}
