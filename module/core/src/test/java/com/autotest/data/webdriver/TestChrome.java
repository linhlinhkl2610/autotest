package com.autotest.data.webdriver;

import org.junit.Test;

import com.autotest.data.webdriver.ChromeWebDriver.ByType;

public class TestChrome {

  @Test
  public void testChrome() throws Exception {
    String chromePath = ChromeWebDriver.class.getClassLoader().getResource("chromedriver_ver74.exe").getPath();
    System.out.println(chromePath);
    System.setProperty("webdriver.chrome.driver", chromePath);
    
    ChromeWebDriver driver = new ChromeWebDriver();
    driver.get("http://www.kenh14.vn");
    
    driver.click(ByType.LINK_TEXT, "Ăn cả thế giới");
    driver.sleep(2000);
  }
}
