package com.georgesykes.tilltechtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class MenuParser {
  private JsonObject menu;
  private HashMap<String, String> shopDetails;
  private HashMap<String, Double> prices;

  public MenuParser(String path) throws IOException {
    this.menu = this.parseMenu(path);
    this.shopDetails = new HashMap();
    this.prices = new HashMap();
  }

  public HashMap getShopDetails() {
    this.shopDetails.put("address", this.menu.getString("address"));
    this.shopDetails.put("shopName", this.menu.getString("shopName"));
    this.shopDetails.put("phone", this.menu.getString("phone"));
    return this.shopDetails;

  }

  public HashMap getMenu() {
    JsonObject priceList = (JsonObject) this.menu.getJsonArray("prices").get(0);
    for (String key : priceList.keySet()) {
      String keyStr = (String)key;
      JsonNumber keyValue = priceList.getJsonNumber(keyStr);
      this.prices.put(keyStr, keyValue.doubleValue());
    }
    return this.prices;
  }

  private JsonObject parseMenu(String path) throws IOException {
      InputStream fis = new FileInputStream(path);
      JsonReader jsonReader = Json.createReader(fis);
      JsonObject jsonObject = jsonReader.readObject();
      jsonReader.close();
      fis.close();
      return jsonObject;
  }

}
