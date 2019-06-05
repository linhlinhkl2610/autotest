package com.autotest.data.webdriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver extends ChromeDriver {

  public enum ByType { ID, CSS, XPATH, CLASS_Name, NAME, LINK_TEXT }
  
  private int sleepTime = 0;
  private int totalSleepTime = 0;
  
  public ChromeWebDriver() {  }
  
  public ChromeWebDriver(int sleepTime) {
    this.sleepTime = sleepTime;
  }

  private By getBy(ByType type, String locator){
    By by=null;
    if(type == ByType.ID){
      by = By.id(locator);
    } else if(type == ByType.CSS){
      by = By.cssSelector(locator);
    } else if(type == ByType.XPATH){
      by = By.xpath(locator);
    } else if(type == ByType.CLASS_Name){
      by = By.className(locator);
    } else if(type == ByType.NAME){
      by = By.name(locator);
    } else if(type == ByType.LINK_TEXT){
      by = By.linkText(locator);
    }
    return by;
  }
  
  public WebElement getElenment(ByType type, String locator){
    return findElement(getBy(type, locator));
  }
  
  public List<WebElement> getElenments(ByType type, String locator){
    return findElements(getBy(type, locator));
  }
  
  public void click(ByType type, String locator, int sleepTime) throws Exception{
    
  }
  
  public void click(ByType type, String locator) throws Exception{
    getElenment(type, locator).click();
    sleep(sleepTime);
  }
  
  public void sleep(int time) throws Exception{
    this.sleepTime += time;
    Thread.sleep(time);
  }
  
  public int getSleepTime() {  return sleepTime;  }
  public void setSleepTime(int sleepTime) {  this.sleepTime = sleepTime;  }

  public int getTotalSleepTime() {  return totalSleepTime;  }
}
