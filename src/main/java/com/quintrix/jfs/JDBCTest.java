package com.quintrix.jfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

  public static void main(String[] args) {
    Connection connection = null;
    Statement insertStmt = null;
    Statement selectStmt = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "password");

      /*
       * insertStmt = connection.createStatement(); insertStmt.
       * execute("INSERT INTO EMPLOYEE (ID,FIRST_NAME,LAST_NAME,STAT_CD) VALUES (1,'Antonio','Marian',5)"
       * );
       */
      selectStmt = connection.createStatement();
      ResultSet rs = selectStmt
          .executeQuery("SELECT ID,FIRST_NAME,LAST_NAME,STAT_ID FROM EMPLOYEES WHERE ID <= 10");
      while (rs.next()) {
        System.out.println(rs.getInt(1));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Closing connection
      try {
        if (connection != null) {
          selectStmt.close();
          insertStmt.close();
          connection.close();
        }
        System.out.println("Connection closed.");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

}
