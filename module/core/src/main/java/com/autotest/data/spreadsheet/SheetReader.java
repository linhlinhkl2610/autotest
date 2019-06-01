package com.autotest.data.spreadsheet;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SheetReader {
  private String  sheetName;

  public SheetReader(String sheetName) {
    this.sheetName = sheetName;
  }
  
  public void doRead(Workbook workbook) throws Exception {
    Sheet sheet = workbook.getSheet(sheetName);
    doRead(sheet);
  }
  
  protected void doRead(Sheet sheet) throws Exception {
    Iterator<Row> iterator = sheet.iterator();
    HeaderMapping headerMapping = new HeaderMapping(iterator.next());
    int rowIdx = 0;
    while (iterator.hasNext()) {
      SSRow currentRow = new SSRow(headerMapping, iterator.next(), rowIdx);
      onProcess(currentRow);
      rowIdx++;
    }
  }
  
  protected void onProcess(SSRow row) throws Exception {
    System.out.print(row.getRowIndex() + ". ");
    String[] cells = row.getCellValuesAsString();
    for(int i = 0; i < cells.length; i++) {
      System.out.print(cells[i] + "--");
    }
    System.out.println();
  }
}