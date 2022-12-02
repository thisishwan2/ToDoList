package com.mysite.ToDoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//db연결과 db클리어(쿼리문 처리)
public class DBConnection {

    private Connection con;
    private Statement stmt;
    public DBConnection(){
        try{
            String url= "jdbc:h2:tcp://localhost/~/ToDoList";

            String user = "sa";
            String passwd = "";

            con = DriverManager.getConnection(url, user, passwd);
            System.out.println("db 연결 성공");

            stmt = con.createStatement();
            System.out.println("Statement 객체 생성 성공");

            stmt.executeUpdate("drop all objects");
            System.out.println("테이블이 삭제됐습니다.");

            con.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("db 연결 실패");
            System.out.println("사유" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new DBConnection();
    }
}
