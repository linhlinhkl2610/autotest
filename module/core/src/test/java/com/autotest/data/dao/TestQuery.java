package com.autotest.data.dao;

import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestQuery {

  @Test
  public void testQueryResult() throws Exception {
    DBConnector connector = new DBConnector(DBConnector.DEFAULT_URL, "dbtest", "root", "");
    Statement state = connector.connect();
    SqlCommand cmd = new SqlCommand(state);
    
    List<SqlRecord> records = cmd.getResults("SELECT * FROM account");
    for (SqlRecord record : records) {
      System.out.println(record.get("loginId"));
    }
  }
}
