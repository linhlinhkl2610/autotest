package com.autotest.data.webdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.autotest.data.webdriver.ChromeWebDriver.ByType;


public class TestChrome {

  private ChromeWebDriver driver;
  
  @Before
  public void init() {
    String chromePath = ChromeWebDriver.class.getClassLoader().getResource("chromedriver_ver74.exe").getPath();
    System.setProperty("webdriver.chrome.driver", chromePath);
    
    driver = new ChromeWebDriver();
  }
  
  @Test
  public void testOpenChrome() throws Exception {
    driver.get("http://www.kenh14.vn");
    
    driver.click(ByType.LINK_TEXT, "Ăn cả thế giới");
    driver.sleep(2000);
  }
  
  @After
  public void teardown() {
    driver.close();
  }
}
