package com.georgesykes.tilltechtest;

public class CustomerDetailsFactory {

  public CustomerDetails getCustomerDetails(int tableNum, int numPeople) {
    return new CustomerDetails(tableNum, numPeople);
  }
}
