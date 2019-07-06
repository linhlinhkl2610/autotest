package com.autotest.intergration;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.autotest.data.webdriver.WebDriver;
import com.autotest.data.webdriver.WebDriver.ByType;
import com.autotest.data.webdriver.WebDriver.WebDriverType;

public class IntergrationTest {

  private WebDriver driver;
  
  @Before
  public void init() {
    String chromePath = WebDriver.class.getClassLoader().getResource("chromedriver_ver75.exe").getPath();
    System.setProperty("webdriver.chrome.driver", chromePath);
    
    driver = new WebDriver(WebDriverType.CHROME, 300);
  }
  
  @Test
  public void testcase1() throws Exception {
    driver.get("https://anycar.vn/");
    
    driver.click(ByType.LINK_TEXT, "Ký gửi xe");
    
    driver.sendKey(ByType.ID, "address", "Ha Noi 2019");
    driver.sendKey(ByType.ID, "mobile", "09090909090");
    // driver.click(ByType.XPATH, "//*[@id=\"recaptcha-anchor\"]");
    
    driver.click(ByType.ID, "btn-submit");
    
    String errorMessage = driver.getText(ByType.ID, "parsley-id-5");
    if (errorMessage.equals("Yêu cầu nhập tên liên hệ")) {
      System.out.println("CASE DUNG");
    } else {
      System.out.println("CASE SAI");
    }
  }
  
  @Test
  public void testcase2() {
    try {
      driver.get("https://anycar.vn/");
      driver.click(ByType.LINK_TEXT, "Tìm mua xe");
      
      List<WebElement> carEles = driver.getElenments(ByType.CLASS_NAME, "card-title");
      if (carEles != null) {
        WebElement carEle = carEles.get(0);
        carEle.click();
      }
      driver.sleep(1000);
      driver.click(ByType.CLASS_NAME, "add-to-interested");
      System.out.println("CASE DUNG");
    } catch (Exception e) {
      System.out.println("CASE SAI");
    }
  }
  
  @Test
  public void testcase3() throws Exception{
    driver.get("https://anycar.vn/");
    driver.click(ByType.LINK_TEXT, "HỆ THỐNG ANYCAR");
    
    WebElement hotlineEle = driver.getElenment(ByType.XPATH, "//*[@id=\"contactDiv\"]/div[2]/div[2]/b[1]");
    if (hotlineEle == null || !hotlineEle.getText().equals("Hotline:")) {
      System.out.println("CASE SAI O HOTLINE");
      return;
    }
    
    WebElement phoneEle = driver.getElenment(ByType.XPATH, "//*[@id=\"contactDiv\"]/div[2]/div[2]/span");
    if (phoneEle == null || !phoneEle.getText().equals("180062166:")) {
      System.out.println("CASE SAI O PHONE");
      return;
    }
    System.out.println("CASE DUNG");
  }
  
  @After
  public void teardown() {
    driver.close();
  }
}
