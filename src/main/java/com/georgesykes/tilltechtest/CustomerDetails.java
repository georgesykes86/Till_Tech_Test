package com.georgesykes.tilltechtest;

import lombok.Data;

@Data
public class CustomerDetails {
  private int tableNum;


  public CustomerDetails(int tableNum, int numPeople){
    this.tableNum = tableNum;
  }

}
