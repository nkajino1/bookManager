package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectSample {

    public static void main(String[] args) {
        //DB接続用定数
        String DATABASE_NAME = "bookmanager";
        String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=JST";
        String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME+PROPATIES;
        //DB接続用・ユーザ定数
        String USER = "root";
        String PASS = "";

        try {
            //MySQL に接続する
            Class.forName("com.mysql.cj.jdbc.Driver");
            //データベースに接続
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement stmt = null;
            ResultSet rs = null;
            //変数
            String sql = "SELECT * FROM bookmanager";
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            // データベースに対する処理
            //System.out.println("データベースに接続に成功");

            //データが続く限り、繰り返す
            while (rs.next()) {
            	//カラム
                String ASSET_NUM = rs.getString("ASSET_NUM");
                String BOOK_NAME = rs.getString("BOOK_NAME");
                String AUTHOR = rs.getString("AUTHOR");
                String LENDING = rs.getString("LENDING");
                String PURCHASE_DATE = rs.getString("PURCHASE_DATE");
                String INSERT_DATETIME = rs.getString("INSERT_DATETIME");
                String UPDATE_DATETIME = rs.getString("UPDATE_DATETIME");

                //カラムのデータ内容
                System.out.print(ASSET_NUM + "\n");
                System.out.print(BOOK_NAME + "\n");
                System.out.print(AUTHOR + "\n");
                System.out.print(LENDING + "\n");
                System.out.print(PURCHASE_DATE + "\n");
                System.out.print(INSERT_DATETIME + "\n");
                System.out.print(UPDATE_DATETIME + "\n");
                System.out.println("");

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}