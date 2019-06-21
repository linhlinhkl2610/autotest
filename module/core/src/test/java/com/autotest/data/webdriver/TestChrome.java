package com.autotest.data.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.autotest.data.webdriver.WebDriver.ByType;
import com.autotest.data.webdriver.WebDriver.WebDriverType;


public class TestChrome {

  private WebDriver driver;
  
  @Before
  public void init() {
    String chromePath = WebDriver.class.getClassLoader().getResource("chromedriver_ver74.exe").getPath();
    System.setProperty("webdriver.chrome.driver", chromePath);
    
    driver = new WebDriver(WebDriverType.CHROME, 5000);
  }
  
  @Test
  public void testOpenChrome() throws Exception {
    driver.get("http://www.kenh14.vn");
    
    driver.click(ByType.LINK_TEXT, "Ăn cả thế giới");
  }
  
  @After
  public void teardown() {
    driver.close();
  }
}
