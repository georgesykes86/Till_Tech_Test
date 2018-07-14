package com.georgesykes.tilltechtest.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.georgesykes.tilltechtest.CustomerDetails;
import com.georgesykes.tilltechtest.CustomerDetailsFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerDetailsTest {
  private CustomerDetails details;
  private CustomerDetailsFactory factory = new CustomerDetailsFactory();
  private final int tableNum = 1;
  private final int numPeople = 4;

  @BeforeEach
  public void setUp() {
    details = factory.getCustomerDetails(tableNum, numPeople);
  }

  @Test
  public void returnsTableNum() {
    assertEquals(tableNum, details.getTableNum());
  }

}
