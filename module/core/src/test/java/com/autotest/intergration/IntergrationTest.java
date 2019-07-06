package com.autotest.intergration;

import org.junit.Before;
import org.junit.Test;

import com.autotest.data.webdriver.WebDriver;
import com.autotest.data.webdriver.WebDriver.ByType;
import com.autotest.data.webdriver.WebDriver.WebDriverType;

public class IntergrationTest {

  private WebDriver driver;
  
  @Before
  public void init() {
    String chromePath = WebDriver.class.getClassLoader().getResource("chromedriver_ver75.exe").getPath();
    System.setProperty("webdriver.chrome.driver", chromePath);
    
    driver = new WebDriver(WebDriverType.CHROME, 0);
  }
  
  @Test
  public void testcase1() throws Exception {
    driver.get("https://anycar.vn/");
    
    driver.click(ByType.LINK_TEXT, "Ký gửi xe");
    
  }
}
