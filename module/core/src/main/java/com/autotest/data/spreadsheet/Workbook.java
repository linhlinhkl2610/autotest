package com.autotest.data.spreadsheet;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Workbook {

  XSSFWorkbook wb;
  
  public Workbook(String file) throws Exception {
    FileInputStream fs = new FileInputStream(file);
    wb = new XSSFWorkbook (fs);
    
  }
  
  public Sheet getSheet(String name) {
    return (Sheet) wb.getSheet(name);
  }
  
  public Sheet getSheet(int index) {
    XSSFSheet p = new Sheet();
    // do whatever
    Sheet c = (Sheet) p;
    return (Sheet) wb.getSheetAt(index);
  }
}
