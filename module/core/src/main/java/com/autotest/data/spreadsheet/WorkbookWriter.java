package com.autotest.data.spreadsheet;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkbookWriter {
  private List<SheetWriter> writers = new ArrayList<>();
  
  public void add(SheetWriter ... writer) {
    for(SheetWriter sel : writer) writers.add(sel);
  }
  
  public void write(String file) throws Exception {
    FileOutputStream os = new FileOutputStream(file);
    write(os);
  }
  
  public void write(OutputStream os) throws Exception {
    Workbook workbook = new XSSFWorkbook();
    for(SheetWriter sel : writers) {
      sel.doWrite(workbook);
    }
    workbook.write(os);
    workbook.close();
  }
}
