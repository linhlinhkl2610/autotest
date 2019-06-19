package com.autotest.data.spreadsheet;

import org.junit.Test;

public class TestXLSXFile {

  @Test
  public void testReadWriteXLSX() throws Exception {
    String file = TestXLSXFile.class.getClassLoader().getResource("test.xlsx").getPath();
    
    Workbook wb = new Workbook(file);
    Sheet sheet = wb.getSheet(0);
    sheet.getSheetName();
  }
}
