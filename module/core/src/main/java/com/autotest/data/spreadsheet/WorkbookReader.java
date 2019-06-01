package com.autotest.data.spreadsheet;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkbookReader {
  private List<SheetReader> readers = new ArrayList<>();
  
  public void add(SheetReader ... reader) {
    for(SheetReader sel : reader) readers.add(sel);
  }
  
  public void read(String file) throws Exception {
    read(new FileInputStream(file));
  }
  
  public void read(InputStream is) throws Exception {
    Workbook workbook = new XSSFWorkbook(is);
    for(SheetReader sel : readers) sel.doRead(workbook);
    workbook.close();
  }
  
}