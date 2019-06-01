package com.autotest.data.spreadsheet;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class HeaderMapping {
  private Map<String, Integer> headers = new HashMap<>();

  public HeaderMapping(Row row) {
    for(int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
      String cell = getCellAsString(row, i);
      headers.put(cell, i);
    }
  }

  public void add(String header, int colIdx) {
    if(headers.containsKey(header)) {
      throw new RuntimeException("Column " + header + " is already existed");
    }
    headers.put(header, colIdx);
  }

  public int getColumnIndex(String header) {
    Integer val = headers.get(header);
    if(val == null) { throw new RuntimeException(); }
    return val.intValue();
  }
  
  String getCellAsString(Row row, int col) {
    Cell currCell = row.getCell(col);
    if(currCell == null) return null;
    if(currCell.getCellTypeEnum() == CellType.NUMERIC) {
      return Double.toString(currCell.getNumericCellValue());
    } else {
      return currCell.getRichStringCellValue().getString();
    }
  }
}
