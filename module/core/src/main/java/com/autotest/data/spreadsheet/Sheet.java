package com.autotest.data.spreadsheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;

@SuppressWarnings("deprecation")
public class Sheet {
  
  private XSSFSheet sheet;
  
  public Sheet(XSSFSheet sheet) {
    this.sheet = sheet;
  }
  
  public String getStringValue(int row, int column) {
    Cell cell = sheet.getRow(row - 1).getCell(column - 1);
    cell.setCellType(CellType.STRING);
    return cell.getStringCellValue();
  }
  
  public boolean getBooleanValue(int row, int column) {
    Cell cell = sheet.getRow(row - 1).getCell(column - 1);
    cell.setCellType(CellType.BOOLEAN);
    return cell.getBooleanCellValue();
  }
  
  public String getName() {
    return sheet.getSheetName();
  }
}
