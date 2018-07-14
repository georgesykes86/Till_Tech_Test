package com.georgesykes.tilltechtest.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.georgesykes.tilltechtest.MenuParser;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuParserTest {
  private MenuParser parser;
  private String filePath = new File("").getAbsolutePath();

  @BeforeEach
  public void setUp() throws IOException {
    parser = new MenuParser(filePath + "/src/main/resources/menu.json");
  }

  @Test
  public void returnsShopDetailsShopNameCorrectly() {
    assertEquals("The Coffee Connection", parser.getShopDetails().get("shopName"));
  }

  @Test
  public void returnsShopDetailsAddressCorrectly() {
    assertEquals("123 Lakeside Way", parser.getShopDetails().get("address"));
  }

  @Test
  public void returnsShopDetailsPhoneCorrectly() {
    assertEquals("441220360070", parser.getShopDetails().get("phone"));
  }
}
