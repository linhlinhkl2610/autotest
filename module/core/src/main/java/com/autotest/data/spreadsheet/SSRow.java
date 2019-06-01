package com.autotest.data.spreadsheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.autotest.util.text.StringUtil;

public class SSRow {
  
  private HeaderMapping headerMapping;
  private Row           row;
  private int           index;

  public SSRow(HeaderMapping headerMapping, Row row, int idx) {
    this.headerMapping = headerMapping;
    this.row = row;
    this.index = idx;
  }
  
  public int getRowIndex() { return index; }
  
  public String getCellAsString(int col) {
    Cell currCell = row.getCell(col);
    if(currCell == null) return null;
    if(currCell.getCellTypeEnum() == CellType.NUMERIC) {
      if (currCell.getCellStyle().getDataFormatString().contains("%")) {
        return currCell.getNumericCellValue() * 100 + "%";
      }
      return Double.toString(currCell.getNumericCellValue());
    } else {
      currCell.setCellType(CellType.STRING);
      //return currCell.getRichStringCellValue().getString();
      return currCell.getStringCellValue();
    }
  }
  
  public String getCellAsString(String colName) {
    int colIdx = headerMapping.getColumnIndex(colName);
    return getCellAsString(colIdx);
  }
  
  public double getCellAsDouble(String colName, double defaultVal) {
    int colIdx = headerMapping.getColumnIndex(colName);
    Cell currCell = row.getCell(colIdx);
    if(currCell == null) return defaultVal;
    if(currCell.getCellTypeEnum() == CellType.NUMERIC) {
      return currCell.getNumericCellValue();
    } else {
      currCell.setCellType(CellType.STRING);
      String val = currCell.getRichStringCellValue().getString();
      if(val == null || StringUtil.isEmpty(val)) return defaultVal;
      return Double.parseDouble(val);
    }
  }
  
  public double getCellAsPercent(String colName, double defaultVal) {
    int colIdx = headerMapping.getColumnIndex(colName);
    Cell currCell = row.getCell(colIdx);
    if(currCell == null) return defaultVal;
    if(currCell.getCellTypeEnum() == CellType.NUMERIC) {
      if (currCell.getCellStyle().getDataFormatString().contains("%")) {
        return currCell.getNumericCellValue();
      }
    } 
    throw new RuntimeException(colName + " is not a % column");
  }
  
  public String[] getCellValuesAsString() {
    String[] cells = new String[row.getPhysicalNumberOfCells()];
    for(int i = 0; i < cells.length; i++) {
      cells[i] = getCellAsString(i);
    }
    return cells;
  }
}
