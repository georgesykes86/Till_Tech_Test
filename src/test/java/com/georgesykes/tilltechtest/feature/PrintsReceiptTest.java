package com.georgesykes.tilltechtest.feature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.georgesykes.tilltechtest.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class PrintsReceiptTest {
  @InjectMocks
  private Till till;

  private final ByteArrayOutputStream output = new ByteArrayOutputStream();

  private final String firstReceipt = "The Coffee Connection\n\n123 Lakeside Way\nPhone: +44 (1220) 360070\n"
      + "Table: 1 / [4]\n\tChoc Mousse      \t\t1 x 8.20\n\tCappucino        \t\t2 x 3.85\n\tMuffin Of The Day\t\t4 x 4.55\n"
      + "Tax  \t\t\t\t\t\t\t\t\t£6.82\nTotal\t\t\t\t\t\t\t\t\t£40.92";

  @BeforeEach
  public void setUp() {
    till = new Till(new ReceiptFactory(), new OrderFactory(), new Printer());
    System.setOut(new PrintStream(output));
  }

  @Test
  public void printsSimpleReceipt() {
    till.addTable(1, 4);
    till.addItem("Choc Mousse", 1);
    till.addItem("Cappucino", 2);
    till.addItem("Muffin Of The Day", 4);
    till.printReceipt();
    assertEquals(firstReceipt, output.toString());
  }

}
