package com.autotest.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnector {

  public static String DEFAULT_URL = "jdbc:mysql://localhost:3306";
  
  public Statement   stmt;
  public Connection  connection;
  
  private String     url;
  private String     dbName;
  private String     user;
  private String     password;
  
  
  public DBConnector(String url, String dbName, String user, String password) {
    this.url = url;
    this.dbName = dbName;
    this.user = user;
    this.password = password;
  }
  
  public Statement connect() throws Exception {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    connection = DriverManager.getConnection(url+"/"+dbName+"?useUnicode=true&characterEncoding=UTF-8&charSet=UTF-8&zeroDateTimeBehavior=convertToNull", user, password);
    stmt = connection.createStatement(); 
    return stmt;
  }
}
