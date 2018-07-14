package com.georgesykes.tilltechtest.unit;

import static org.mockito.Mockito.verify;

import com.georgesykes.tilltechtest.CustomerDetails;
import com.georgesykes.tilltechtest.ItemList;
import com.georgesykes.tilltechtest.Order;
import com.georgesykes.tilltechtest.OrderFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderTest {
  private Order order;
  private OrderFactory factory = new OrderFactory();

  @Mock
  private CustomerDetails details;

  @Mock
  private ItemList list;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    order = factory.getOrder(details, list);
  }

  @Test
  public void addsItem() {
    order.addItem("Coffee", 3);
    verify(list).addItem("Coffee", 3);
  }

}
