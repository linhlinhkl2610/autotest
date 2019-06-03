package com.autotest.data.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlCommand {

  public Statement   stmt;
  
  public SqlCommand(Statement stmt) {
    this.stmt = stmt;
  };
  
  public List<SqlRecord> getResults(String query) throws Exception {
//    ResultSet rs =  stmt.executeQuery(query);
//    List<Object> results = new ArrayList<Object>();
//
//    ResultSetMetaData metadata = rs.getMetaData();
//    int columnCount = metadata.getColumnCount();
//    for (int i = 1; i <= columnCount; i++) {
//      // writeToFile(metadata.getColumnName(i) + ", ");
//      System.out.println(metadata.getColumnName(i));
//    }
//    while (rs.next()) {
//      String row = "";
//      for (int i = 1; i <= columnCount; i++) {
//        row += rs.getString(i) + ", ";
//        System.out.println(row);
//      }
//      System.out.println();
//      // writeToFile(row);
//    }
//    
//    return results;
    
    ResultSet rs =  stmt.executeQuery(query);
    ResultSetMetaData meta = rs.getMetaData();
    String[] column = new String[meta.getColumnCount()];
    for(int i = 0; i < column.length; i++) {
      column[i] =  meta.getColumnLabel(i + 1);
    }
    
    List<Object[]> holder = new ArrayList<>();
    while(rs.next()) {
      Object[] cell = new Object[column.length];
      for(int i = 0; i < column.length; i++) {
        cell[i] = rs.getObject(column[i]);
      }
      holder.add(cell);
    }
    Object[] rows = new Object[holder.size()];
    rows = holder.toArray(rows);
    return new SqlSelectView(column, rows).getRecords();
  }
}
