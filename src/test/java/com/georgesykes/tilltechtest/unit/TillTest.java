package com.georgesykes.tilltechtest.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.georgesykes.tilltechtest.CustomerDetails;
import com.georgesykes.tilltechtest.CustomerDetailsFactory;
import com.georgesykes.tilltechtest.ItemFactory;
import com.georgesykes.tilltechtest.ItemList;
import com.georgesykes.tilltechtest.ItemListFactory;
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
  private HashMap<String, String> menu;

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

  @Mock
  private ItemListFactory ilf;

  @Mock
  private ItemFactory itemFactory;

  @Mock
  private CustomerDetailsFactory cdf;

  @Mock
  private ItemList list;

  @Mock
  private CustomerDetails details;

  @BeforeAll
  public void setUpShopDetails() {
    shopDetails = new HashMap();
    menu = new HashMap();
  }

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(orderFactory.getOrder(anyObject(), anyObject())).thenReturn(order);
    when(receiptFactory.getReceipt(anyObject(), anyObject())).thenReturn(receipt);
    when(parser.getShopDetails()).thenReturn(shopDetails);
    when(cdf.getCustomerDetails(anyInt(),anyInt())).thenReturn(details);
    when(ilf.getItemList(anyObject(), anyObject())).thenReturn(list);
    till = new Till(receiptFactory, orderFactory, printer, parser, ilf, itemFactory, cdf);
    till.addTable(1,4);
  }

  @Test
  public void addsTableDetails() {
    verify(orderFactory).getOrder(details, list);
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
