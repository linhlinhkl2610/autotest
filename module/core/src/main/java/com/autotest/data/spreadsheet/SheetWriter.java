package com.autotest.data.spreadsheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SheetWriter {
  private String  sheetName;

  public SheetWriter(String sheetName) {
    this.sheetName = sheetName;
  }
  
  public void doWrite(Workbook workbook) throws Exception {
    Sheet sheet = workbook.createSheet(sheetName);
    doWrite(sheet);
  }
  
  protected void doWrite(Sheet sheet) throws Exception {
    Object[][] samples = {
      {"Datatype", "Type", "Size(in bytes)"},
      {"int", "Primitive", 2},
      {"float", "Primitive", 4},
      {"double", "Primitive", 8},
      {"char", "Primitive", 1},
      {"String", "Non-Primitive", "No fixed size"}
    };
    for(int i = 0; i < samples.length; i++) {
      Object[] sample = samples[i];
      Row row = sheet.createRow(i);
      int colNum = 0;
      for (Object field : sample) {
        Cell cell = row.createCell(colNum++);
        if (field instanceof String) {
          cell.setCellValue((String) field);
        } else if (field instanceof Integer) {
          cell.setCellValue((Integer) field);
        }
      }
    }
  }
  
  protected void createRowHeader(Sheet sheet, int rowIdx, String ... header) {
    Row row = sheet.createRow(rowIdx);
    for (int i = 0; i < header.length; i++) {
      Cell cell = row.createCell(i);
      cell.setCellValue((header[i]));
    }
  }
  
  protected void createRowData(Sheet sheet, int rowIdx, Object ... cells) {
    Row row = sheet.createRow(rowIdx);
    for (int i = 0; i < cells.length; i++) {
      Cell cell = row.createCell(i);
      Object data = cells[i];
      if(data == null) continue;
      if (data instanceof Integer) {
        cell.setCellValue((Integer) data);
      } else if(data instanceof String) {
        cell.setCellValue((String) data);
      } else {
        cell.setCellValue(data.toString());
      }
    }
  }
}