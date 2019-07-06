package com.autotest.data.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriver {

  public enum WebDriverType   { CHROME, FIREFOX };
  public enum ByType          { ID, CSS, XPATH, CLASS_NAME, NAME, LINK_TEXT }
  private int totalSleepTime  = 0;
  
  private RemoteWebDriver driver;
  private int sleepTime       = 0;
  
  
  public WebDriver(WebDriverType type) {
    if (type == WebDriverType.CHROME) {
      driver = new ChromeDriver();
    } else if (type == WebDriverType.FIREFOX) {
      driver = new FirefoxDriver();
    }
  }
  
  public WebDriver(WebDriverType type, int sleepTime) {
    this(type);
    this.sleepTime = sleepTime;
  }
  
  public WebElement getElenment(ByType type, String locator){
    return driver.findElement(getBy(type, locator));
  }
  
  public List<WebElement> getElenments(ByType type, String locator){
    return driver.findElements(getBy(type, locator));
  }
  
  public void click(ByType type, String locator, int sleepTime) throws Exception{
    getElenment(type, locator).click();
    sleep(sleepTime);
  }
  
  public void click(ByType type, String locator) throws Exception{
    getElenment(type, locator).click();
    sleep(sleepTime);
  }
  
  public void sleep(int time) throws Exception{
    this.sleepTime += time;
    Thread.sleep(time);
  }
  
  private By getBy(ByType type, String locator){
    By by = null;
    if(type == ByType.ID){
      by = By.id(locator);
    } else if(type == ByType.CSS){
      by = By.cssSelector(locator);
    } else if(type == ByType.XPATH){
      by = By.xpath(locator);
    } else if(type == ByType.CLASS_NAME){
      by = By.className(locator);
    } else if(type == ByType.NAME){
      by = By.name(locator);
    } else if(type == ByType.LINK_TEXT){
      by = By.linkText(locator);
    }
    return by;
  }
  
  public int getSleepTime() {  return sleepTime;  }
  public void setSleepTime(int sleepTime) {  this.sleepTime = sleepTime;  }

  public RemoteWebDriver getDriver() { return driver; };
  public int getTotalSleepTime() {  return totalSleepTime;  }
  
  public void get(String url) { driver.get(url); }
  public void close() {  driver.close(); }
}
