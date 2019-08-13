package customList;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    //connector 8.0.17
    //MySQL 5.7.27
    public static void main(String[] args) {
        CustomManager manager = CustomManager.createCustomManager();

        try {
            manager.readFile("customList.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //get ArrayList from CustomManager class
        ArrayList<CustomInfo> list = manager.getList();

        //MYSQL
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Use com.mysql.cj.jdbc.Driver instead of com.mysql.jdbc.Driver

            //specify the correct URL
            String url = "jdbc:mysql://localhost/customers?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

            //1. create connection to DB
            conn = DriverManager.getConnection(url, "root", "1234");
            //to check the state - toString()
            System.out.println(conn.toString());
            int size = list.size();

            for (int i = 0; i < size; i++) {
                CustomInfo cusList = list.get(i);
                String sql = "insert into customers values(?,?,?,?,?,?)"; //PreparedStatement 는 변수값대신 '?' 사용
                //INSERT
                pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, cusList.getId()); //'?' 의 순서를 1부터 차례대로 숫자로 표시해 준다.
                pstmt.setString(2, cusList.getName());
                pstmt.setString(3, cusList.getPhone());
                pstmt.setString(4, cusList.getEmail());
                pstmt.setString(5, cusList.getAccountNum());
                pstmt.setString(6, cusList.getAddress());
                pstmt.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
