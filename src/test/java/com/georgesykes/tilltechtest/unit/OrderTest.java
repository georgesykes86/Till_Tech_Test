package com.georgesykes.tilltechtest.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.georgesykes.tilltechtest.CustomerDetails;
import com.georgesykes.tilltechtest.ItemList;
import com.georgesykes.tilltechtest.Order;
import com.georgesykes.tilltechtest.OrderFactory;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderTest {
  private Order order;
  private OrderFactory factory = new OrderFactory();
  private ArrayList<HashMap> items = new ArrayList();

  @Mock
  private CustomerDetails details;

  @Mock
  private ItemList list;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    when(details.getTableNum()).thenReturn(2);
    when(details.getNumPeople()).thenReturn(5);
    when(list.getItems()).thenReturn(items);
    order = factory.getOrder(details, list);
  }

  @Test
  public void addsItem() {
    order.addItem("Coffee", 3);
    verify(list).addItem("Coffee", 3);
  }

  @Test
  public void returnTableNum() {
    assertEquals(2, order.getTableNum());
  }

  @Test
  public void returnNumberPeople() {
    assertEquals(5, order.getPeopleNum());
  }

  @Test
  public void returnItemList() {
    assertEquals(items, order.getItems());
  }

}
