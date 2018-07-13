package com.georgesykes.tilltechtest.unit;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.georgesykes.tilltechtest.Order;
import com.georgesykes.tilltechtest.OrderFactory;
import com.georgesykes.tilltechtest.Printer;
import com.georgesykes.tilltechtest.Receipt;
import com.georgesykes.tilltechtest.ReceiptFactory;
import com.georgesykes.tilltechtest.Till;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TillTest {
  private Till till;

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

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    till = new Till(receiptFactory, orderFactory, printer);
    when(orderFactory.getOrder()).thenReturn(order);
    when(receiptFactory.getReceipt(any())).thenReturn(receipt);
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
    verify(receiptFactory).getReceipt(order);
  }

  @Test
  public void printsReceipt() {
    till.printReceipt();
    verify(printer).print(receipt);
  }


}
